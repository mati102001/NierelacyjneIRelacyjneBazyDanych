package model;

import Utils.GsonUtils;
import Utils.RuntimeTypeAdapterFactory;
import jakarta.json.bind.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

@BsonDiscriminator(key = "type", value = "Client")
@JsonbTypeInfo(key = "Client", value = {@JsonbSubtype(alias = "PrivatePerson", type = PrivatePerson.class), @JsonbSubtype(alias = "Team", type = Team.class)})
public abstract class Client implements Serializable {

    @BsonProperty("phone_number")
    @JsonbProperty("phone_number")
    private String phoneNumber;

    @BsonId
    @JsonbProperty("id")
    private final String clientId;

    @BsonProperty("number_of_players")
    @JsonbProperty("number_of_players")
    private int numberOfPlayers;

    @BsonProperty("archived")
    @JsonbProperty("archived")
    private Boolean archived = false;

    private static final RuntimeTypeAdapterFactory<Client> adapter =
            RuntimeTypeAdapterFactory.of(Client.class);

    private static final HashSet<Class<?>> registeredClasses= new HashSet<Class<?>>();

    static {
        GsonUtils.registerType(adapter);
    }

    private synchronized void registerClass() {
        if (!registeredClasses.contains(this.getClass())) {
            registeredClasses.add(this.getClass());
            adapter.registerSubtype(this.getClass());
        }
    }


    public Client(String phoneNumber, int numberOfPlayers) {
        registerClass();
        this.phoneNumber = phoneNumber;
        this.clientId = UUID.randomUUID().toString();
        this.numberOfPlayers = numberOfPlayers;
    }

    @BsonCreator
    @JsonbCreator
    public Client(@JsonbProperty("phone_number") @BsonProperty("phone_number") String phoneNumber, @JsonbProperty("number_of_players") @BsonProperty("number_of_players") int numberOfPlayers,  @JsonbProperty("id") @BsonId String id) {
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

