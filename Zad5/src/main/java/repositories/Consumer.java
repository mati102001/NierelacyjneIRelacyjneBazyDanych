package repositories;

import Utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import model.Rent;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class Consumer {
    private Repository<Rent> mongo = new ConcreteRentMongoDBRepository("mongodb://hardkorowy-koxu:eJ8LsRoGZQvGhkvnW9PQAYZ2f9zXPaaaAlk98Ok5nrkXRuadxOlz4P499A2YbSl4D1km1vW7GoHfACDbM2Gbvw==@hardkorowy-koxu.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@hardkorowy-koxu@");
    private RentRedisRepository rentRepository = new RentRedisRepository(mongo);

    private Properties adminProperties;
    private final String consumerGroupName = "rent-consumer";
    private Jsonb jsonb = JsonbBuilder.create();
    private List<KafkaConsumer<UUID, String>> consumerGroup = new ArrayList<>();


    public Consumer() {
        this.adminProperties = new Properties();
        this.adminProperties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9192,kafka1:9292,kafka3:9392");
    }

    private List<ConsumerGroupDescription> getConsumerGroupInfo(){
        List<ConsumerGroupDescription> descriptions = new ArrayList<ConsumerGroupDescription>();
        try(Admin admin = Admin.create(this.adminProperties)){
            DescribeConsumerGroupsResult describeConsumerGroupsResult =
                    admin.describeConsumerGroups(List.of(consumerGroupName));
            Map<String, KafkaFuture<ConsumerGroupDescription>> describedGroups = describeConsumerGroupsResult.describedGroups();
            for (Future<ConsumerGroupDescription> group : describedGroups.values()) {
                ConsumerGroupDescription consumerGroupDescription = null;
                try {
                    consumerGroupDescription = group.get();
                    descriptions.add(consumerGroupDescription);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return descriptions;

    }
    public void consume(){
        try(Admin admin = Admin.create(this.adminProperties)) {
            admin.deleteConsumerGroups(List.of(consumerGroupName));
        }

        Properties consumerConfig = new Properties();
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupName);//dynamiczny przydział
        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9192,kafka2:9292,kafka3:9392");

        for(int i =0; i<2; i++) {
            KafkaConsumer consumer = new KafkaConsumer(consumerConfig);
            consumer.subscribe(List.of("rents"));
            consumerGroup.add(consumer);
        }
        try (KafkaConsumer consumer = new KafkaConsumer(consumerConfig)) {
            consumer.subscribe(List.of("rents"));

            for(ConsumerGroupDescription desc : getConsumerGroupInfo()){
                System.out.println(desc);
                for(MemberDescription member : desc.members()){
                    System.out.println(member);
                }
            }

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    String key = record.key();
                    String value = record.value();
                    Rent rent = jsonb.fromJson(value, Rent.class);
                    System.out.println(key + " " + rent);
                    rentRepository.add(rent);
                    consumer.commitSync();
                }
            }
    }
    }
}
