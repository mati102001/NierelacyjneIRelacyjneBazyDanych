package model;

import managers.ClientManager;
import managers.RentManager;
import managers.SportCentre;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.SportCentreRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Client client5 = new PrivatePerson("123a3123", 11992, "Wdaiktor", "Malavasi");
        SportField field1 = new BasketballField("gum", "basketball", 2221);
        SportField field2 = new BasketballField("gu321m", "basketb21all",2221);
        LocalDate date = LocalDate.of(2022, 10, 20);
        LocalTime loctime1 = LocalTime.of(12,0);
        LocalTime loctime3 = LocalTime.of(13,0);
        LocalTime loctime2 = LocalTime.of(14,0);
        LocalTime loctime4 = LocalTime.of(15,0);
        Client client6 = new PrivatePerson("1dad3", 139992, "Wdikaor", "a");

        ClientRepository cr = new ClientRepository();
        RentRepository rp = new RentRepository();
        SportCentreRepository s = new SportCentreRepository();
        Rent rent3 = new Rent(date, loctime1, loctime4, client6, field1);
        RentManager rm = new RentManager(rp);
        ClientManager cm = new ClientManager(cr);
        SportCentre sc = new SportCentre(s);
        cm.registerClient(client5);
        cm.registerClient(client6);
        sc.registerSportField(field1);
        sc.registerSportField(field2);
        rm.registerRent(rent3);
        rm.registerRent(rent3);
    }

}
