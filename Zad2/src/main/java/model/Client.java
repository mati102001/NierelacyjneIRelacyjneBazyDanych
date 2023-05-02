package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.UUID;

@BsonDiscriminator(key = "type", value = "ClientDisc")
public abstract class Client implements Serializable {

    @BsonProperty("phone_number")
    private String phoneNumber;

    @BsonId
    private final String clientId;

    @BsonProperty("number_of_players")
    private int numberOfPlayers;

    @BsonProperty("archived")
    private Boolean archived = false;


    public Client(String phoneNumber, int numberOfPlayers) {
        this.phoneNumber = phoneNumber;
        this.clientId = UUID.randomUUID().toString();
        this.numberOfPlayers = numberOfPlayers;
    }

    @BsonCreator
    public Client(@BsonProperty("phone_number") String phoneNumber, @BsonProperty("number_of_players") int numberOfPlayers, @BsonId String id) {
        this.phoneNumber = phoneNumber;
        this.clientId = id;
        this.numberOfPlayers = numberOfPlayers;
    }

    public Client() {
        this.clientId = UUID.randomUUID().toString();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("phoneNumber", phoneNumber)
                .append("clientId", clientId)
                .append("numberOfPlayers", numberOfPlayers)
                .append("archived", archived)
                .toString();
    }
}

