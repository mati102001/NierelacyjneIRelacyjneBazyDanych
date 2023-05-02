package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "team")

public class Team extends Client implements Serializable {

    @Column(name = "name")
    private String name;

    public Team(String phoneNumber, int numberOfPlayers, String name) {
        super(phoneNumber, numberOfPlayers);
        this.name = name;
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}