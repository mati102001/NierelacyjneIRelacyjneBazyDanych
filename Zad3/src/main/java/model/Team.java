package model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
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
    @JsonbProperty("nameTeam")
    private String name;

    public Team(String phoneNumber, int numberOfPlayers, String name) {
        super(phoneNumber, numberOfPlayers);
        this.name = name;
    }

    @BsonCreator
    @JsonbCreator
    public Team(@BsonProperty("phone_number") @JsonbProperty("phone_number") String phoneNumber, @BsonProperty("number_of_players") @JsonbProperty("number_of_players") int numberOfPlayers, @BsonProperty("nameTeam") @JsonbProperty("nameTeam") String name, @BsonId @JsonbProperty("id") String id) {
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