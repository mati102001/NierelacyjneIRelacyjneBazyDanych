package managers;

import model.Rent;
import repositories.ConcreteRentMongoDBRepository;

import java.io.Serializable;

public class RentManager implements Serializable {

    private ConcreteRentMongoDBRepository rentRepository;

    public RentManager(ConcreteRentMongoDBRepository rentRepository) {
        if (rentRepository == null) {
            throw new IllegalArgumentException("Rent repositiories cannot be null");
        } else {
            this.rentRepository = rentRepository;
        }
    }

    public Rent registerRent(Rent rent) {
        Rent newRent = rentRepository.get(rent.getRentId());
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
