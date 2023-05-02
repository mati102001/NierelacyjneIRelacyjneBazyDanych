package RepositoriesTest;

import Repository.Client.ClientRepository;
import Repository.Rent.RentRepository;
import model.Client;
import model.Rent;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentRepositoryTest {
    RentRepository rentRepository;

    Rent rent1;

    Rent rent2;

    LocalTime time1;

    LocalTime time2;

    LocalTime time3;

    LocalDate date;

    @Before
    public void init() {
        rentRepository = new RentRepository();
        time1 = LocalTime.of(10,0);
        time2 = LocalTime.of(11,0);
        time3 = LocalTime.of(12,0);
        date = LocalDate.now();

        rent1 = new Rent ("111111111", time1, time2, date, "555555555", "666666666");
        rent2 = new Rent( "222222222", time2, time3, date, "888888888", "999999999");

        rentRepository.add(rent1);
        rentRepository.add(rent2);
    }

    @Test
    public void getRentByIdTest() {
        System.out.println(rent1.getId());
        Rent newRent = rentRepository.getRentById(rent1.getId());
        assertEquals(newRent.getStart(), rent1.getStart());
    }

    @Test
    public void findAllRentsTest() {
        assertNotNull(rentRepository.getAllRents());
    }

    @Test(expected = NullPointerException.class)
    public void deleteRentTest() {
        rentRepository.removeById(rent1.getId());
        rentRepository.get(rent1.getId());
    }

    @Test
    public void updateRentTest() {
        Rent rent = rentRepository.get(rent2.getId());
        rent.setStart(LocalTime.of(22,0));
        rentRepository.update(rent);
        assertEquals(LocalTime.of(22,0), rentRepository.get(rent2.getId()).getStart());
    }
}
