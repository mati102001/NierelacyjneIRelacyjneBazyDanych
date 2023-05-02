package repositories;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

public class RentRepositoryTest {
    RentRepository rr = new RentRepository("mongodb://hardkorowy-koxu:eJ8LsRoGZQvGhkvnW9PQAYZ2f9zXPaaaAlk98Ok5nrkXRuadxOlz4P499A2YbSl4D1km1vW7GoHfACDbM2Gbvw==@hardkorowy-koxu.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@hardkorowy-koxu@");
    Client client = new PrivatePerson("1dad3", 139992, "Wdikaor", "a");
    SportField field = new BasketballField("dsaddas", "adasdasd", 2137);
    Rent rent = new Rent(LocalDate.of(2222,11,21), LocalTime.of(21, 37), LocalTime.of(22,37), client, field);

    @Test
    void addTest() {
        rr.add(rent);
        Assertions.assertEquals(rent.getBeginTime(), rr.get(rent.getRentId()).getBeginTime());
        Assertions.assertEquals(rent.getClient().getClientId(), rr.get(rent.getRentId()).getClient().getClientId());
        Assertions.assertEquals(rent.getField().getSportFieldId(), rr.get(rent.getRentId()).getField().getSportFieldId());
        rr.remove(rent.getRentId());
    }

    @Test
    void removeTest() {
        rr.add(rent);
        rr.remove(rent.getRentId());
        Assertions.assertNull(rr.get(rent.getRentId()));
    }

    @Test
    void getTest() {
        rr.add(rent);
        Assertions.assertNotNull(rr.get(rent.getRentId()));
    }

    @Test
    void updateTest() {
        rr.add(rent);
        rent.setArchived(true);
        rr.update(rent);
        Assertions.assertEquals(rent.isArchived(), rr.get(rent.getRentId()).isArchived());
    }
}
