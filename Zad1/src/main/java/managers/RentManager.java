package managers;

import jakarta.persistence.*;
import model.Client;
import model.Rent;
import model.SportField;
import repositories.RentRepository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RentManager implements Serializable {

    private RentRepository rentRepository;

    public RentManager(RentRepository rentRepository) {
        if (rentRepository == null) {
            throw new IllegalArgumentException("Rent repositiories cannot be null");
        } else {
            this.rentRepository = rentRepository;
        }
    }

    public Rent registerRent(Rent rent) {
        Rent newRent = rentRepository.get(rent.getId());
        if(newRent == null) {
            rentRepository.add(rent);
            return rent;
        } else {
            newRent.setArchived(false);
            return newRent;
        }
    }

    public void unregisterClient(Rent rent) {
        if(rent != null) {
            rent.setArchived(true);
        }
    }

}
