package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)


public abstract class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "client_id", unique = true)
    private final String clientId;

    @Column(name = "number_of_players")
    private int numberOfPlayers;

    @Column(name = "is_archived")
    private Boolean archived = false;

    public Client(String phoneNumber, int numberOfPlayers) {
        this.phoneNumber = phoneNumber;
        this.clientId = UUID.randomUUID().toString();
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
    public long getId() {
        return id;
    }
}