package RepositoriesTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.SportCentreRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
/*
public class interfaceTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ClientRepository cr;
    private static RentRepository rr;
    private static SportCentreRepository scr;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        em = emf.createEntityManager();
        cr = new ClientRepository();
        rr = new RentRepository();
        scr = new SportCentreRepository();
    }

    @AfterAll
    static void afterAll() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    void addSportField() {
        SportField sf = new FootballField("ala", "pilka",  "test");
        scr.add(sf);
        assertEquals(sf, scr.get(sf.getId()));
    }

    @Test
    void deleteSportField() {
        SportField sf = new FootballField("ala2", "pilka2",  "test2");
        scr.add(sf);
        scr.remove(sf);
        assertNull(scr.get(sf.getId()));
    }
    @Test
    void addClient() {
        Client c = new PrivatePerson("31313131", 11, "lala", "po");
        cr.add(c);
        assertEquals(c, cr.get(c.getId()));
    }

    @Test
    void deleteClient() {
        Client c = new PrivatePerson("31313131", 11, "lala", "po");
        cr.add(c);
        cr.remove(c);
        assertNull(cr.get(c.getId()));
    }
    @Test
    void addRent() {
        Client c = new PrivatePerson("31313131", 11, "lala", "po");
        SportField sf = new FootballField("ala2", "pilka2",  "test2");

        LocalDate date = LocalDate.of(2022, 10, 20);
        LocalTime loctime1 = LocalTime.of(12,4);
        LocalTime loctime2 = LocalTime.of(12,55);
        Rent r = new Rent(date, loctime1, loctime2, c, sf);
        rr.add(r);
        assertNotNull(rr.get(r.getId()));
    }

    @Test
    void deleteRent() {
        Client c = new PrivatePerson("31313131", 11, "lala", "po");
        SportField sf = new FootballField("ala2", "pilka2",  "test2");

        LocalDate date = LocalDate.of(2022, 10, 20);
        LocalTime loctime1 = LocalTime.of(12,0);
        LocalTime loctime2 = LocalTime.of(13,0);
        Rent r = new Rent(date, loctime1, loctime2, c, sf);
        rr.add(r);
        rr.remove(r);
        assertNull(rr.get(r.getId()));
    }
}*/

