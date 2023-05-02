package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@BsonDiscriminator(key = "type", value = "team")

public class Team extends Client implements Serializable {

    @BsonProperty("nameTeam")
    private String name;

    @BsonCreator
    public Team(String phoneNumber, int numberOfPlayers, String name) {
        super(phoneNumber, numberOfPlayers);
        this.name = name;
    }

    @BsonCreator
    public Team(@BsonProperty("phone_number")String phoneNumber, @BsonProperty("number_of_players") int numberOfPlayers, @BsonProperty("nameTeam") String name, @BsonId String id) {
        super(phoneNumber, numberOfPlayers, id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}