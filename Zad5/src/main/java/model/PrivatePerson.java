package model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@BsonDiscriminator(key = "type", value = "privatePerson")
public class PrivatePerson extends Client implements Serializable {
    @BsonProperty("first_name")
    @JsonbProperty("first_name")
    private String firstName;
    @BsonProperty("last_name")
    @JsonbProperty("last_name")
    private String lastName;

    public PrivatePerson(String phoneNumber, int numberOfPlayers, String firstName,
                          String lastName) {
        super(phoneNumber, numberOfPlayers);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @BsonCreator
    @JsonbCreator
    public PrivatePerson(@BsonProperty("phone_number") @JsonbProperty("phone_number") String phoneNumber, @BsonProperty("number_of_players") @JsonbProperty("number_of_players") int numberOfPlayers, @BsonProperty("first_name") @JsonbProperty("first_name") String firstName,
                         @BsonProperty("last_name") @JsonbProperty("last_name") String lastName, @BsonId @JsonbProperty("id") String id) {
        super(phoneNumber, numberOfPlayers, id);
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(super.toString())
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }
}