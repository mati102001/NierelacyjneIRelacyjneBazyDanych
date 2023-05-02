package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "private_person")

public class PrivatePerson extends Client implements Serializable {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public PrivatePerson(String phoneNumber, int numberOfPlayers, String firstName, String lastName) {
        super(phoneNumber, numberOfPlayers);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PrivatePerson() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}