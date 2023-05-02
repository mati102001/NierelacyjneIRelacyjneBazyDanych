package repositories;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RentRedisRepositoryTest {
    Client client6 = new PrivatePerson("1dad3", 139992, "Wdikaor", "a");
    SportField field = new BasketballField("dsaddas", "adasdasd", 2137);
    Rent rent = new Rent(LocalDate.of(2222,11,21), LocalTime.of(21, 37), LocalTime.of(22,37), client6, field);
    Rent rent2 = new Rent(LocalDate.of(2222,11,21), LocalTime.of(21, 37), LocalTime.of(22,37), client6, field);

    Repository<Rent> mongoDB = new ConcreteRentMongoDBRepository();
    RentRedisRepository rrr = new RentRedisRepository(mongoDB);
    RentRedisRepository rrr2 = new RentRedisRepository(null);

    @Test
    void addTest() {
        rrr.add(rent);
        Rent testRent = rrr.get(rent.getRentId());
        Assertions.assertEquals(testRent.getRentId(), rent.getRentId());
    }

    @Test
    void clearCacheTest() {
        rrr.add(rent);
        rrr.add(rent2);
        rrr.clearCache();
        Assertions.assertEquals(null, rrr.get(rent2.getRentId()));
        Assertions.assertEquals(null, rrr.get(rent.getRentId()));
    }

    @Test
    void getTestWithRedis() {
        rrr.add(rent);
        Rent gotRent = rrr.get(rent.getRentId());
        Assertions.assertEquals(gotRent.getRentId(), rent.getRentId());
    }

    @Test
    void getTestNoRedis() {
        rrr.add(rent);
        Rent gotRent = new Rent();
        try {
            rrr.close();
            gotRent = rrr.get(rent.getRentId());
        } catch (IOException e) {
            Assertions.assertEquals(gotRent.getRentId(), rent.getRentId());
        }

    }
}
