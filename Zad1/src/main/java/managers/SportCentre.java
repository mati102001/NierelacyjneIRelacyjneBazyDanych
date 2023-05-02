package managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.SportField;
import repositories.ClientRepository;
import repositories.RentRepository;
import repositories.SportCentreRepository;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SportCentre implements Serializable {

    private SportCentreRepository sportCentreRepository;

    public SportCentre(SportCentreRepository sportCentreRepository) {
        if (sportCentreRepository == null) {
            throw new IllegalArgumentException("clientRepository cannot be null");
        } else {
            this.sportCentreRepository = sportCentreRepository;
        }
    }

    public SportField registerSportField(SportField sportField) {
        SportField newSportCentre = sportCentreRepository.get(sportField.getId());
        if(newSportCentre == null) {
            sportCentreRepository.add(sportField);
            return sportField;
        } else {
            newSportCentre.setArchived(false);
            return newSportCentre;
        }
    }

    public void unregisterSportField(SportField sportField) {
        if(sportField != null) {
            sportField.setArchived(true);
        }
    }
}
