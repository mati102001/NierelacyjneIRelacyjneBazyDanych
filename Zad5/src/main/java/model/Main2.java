package model;

import Utils.GsonUtils;
import com.google.gson.Gson;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import repositories.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Main2 {

    public static void main(String[] args) throws Exception {
        Client client5 = new PrivatePerson("123a3123", 11992, "Wdaiktor", "Malavasi");
//        Client team1 = new Team("1dad3", 139992, "Wdikaor", "a");
        SportField field = new BasketballField("dsaddas", "adasdasd", 2137);
        Rent rent = new Rent(LocalDate.of(2222,11,21), LocalTime.of(21, 37), LocalTime.of(22,37), client5, field);
//        Client team = new Team("lsada", 11,"dasda");
//        Config cfg = new Config();
//        System.out.println(cfg.getProperty("redisUrl"));
//        Repository<Rent> mongoDB = new ConcreteRentMongoDBRepository();
//        mongoDB = new RentRedisRepository(mongoDB);
//        ConcreteRentMongoDBRepository mongo = ne
//
//
//        mongoDB.add(rent);
//        mongoDB.get("3bb4f7ca-9a56-425d-8979-952955bafc55");
//        System.out.println(mongoDB.get("1e25d871-84e6-496f-8f57-21e6948037b0"));
//        rrr.clearCache();
        ConcreteRentMongoDBRepository concreteRentMongoDBRepository =
                new ConcreteRentMongoDBRepository("mongodb://hardkorowy-koxu:eJ8LsRoGZQvGhkvnW9PQAYZ2f9zXPaaaAlk98Ok5nrkXRuadxOlz4P499A2YbSl4D1km1vW7GoHfACDbM2Gbvw==@hardkorowy-koxu.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@hardkorowy-koxu@");

        Jsonb jsonb = JsonbBuilder.create();
        System.out.println(jsonb.toJson(rent));
        Consumer consumer = new Consumer();
        consumer.consume();

    }
}
