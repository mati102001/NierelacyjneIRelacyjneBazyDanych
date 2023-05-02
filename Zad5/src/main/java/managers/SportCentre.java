package managers;

import model.SportField;
import repositories.SportCentreRepository;

import java.io.Serializable;

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
        SportField newSportCentre = sportCentreRepository.get(sportField.getSportFieldId());
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
