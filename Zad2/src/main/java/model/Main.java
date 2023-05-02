package model;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import managers.ClientManager;
import managers.RentManager;
import managers.SportCentre;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.pojo.PropertyCodecProvider;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.SportCentreRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.bson.codecs.pojo.Conventions.DEFAULT_CONVENTIONS;

public class Main {

    public static void main(String[] args) {
        Client client5 = new PrivatePerson("123a3123", 11992, "Wdaiktor", "Malavasi");
        Client client6 = new PrivatePerson("1dad3", 139992, "Wdikaor", "a");
        SportField field = new BasketballField("dsaddas", "adasdasd", 2137);
        Rent rent = new Rent(LocalDate.of(2222,11,21), LocalTime.of(21, 37), LocalTime.of(22,37), client5, field);
        Client team = new Team("lsada", 11,"dasda");
        ClientRepository cr = new ClientRepository();
        SportCentreRepository scr = new SportCentreRepository();
        RentRepository rr = new RentRepository();

        rr.add(rent);
        rr.get(rent.getRentId());

    }
}
