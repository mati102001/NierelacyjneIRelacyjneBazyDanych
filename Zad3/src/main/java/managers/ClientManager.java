package managers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Client;
import model.PrivatePerson;
import repositories.ClientRepository;

import java.io.Serializable;

public class ClientManager implements Serializable {

    private ClientRepository clientRepository;

    public ClientManager(ClientRepository clientRepository) {
        if (clientRepository == null) {
            throw new IllegalArgumentException("clientRepository cannot be null");
        } else {
            this.clientRepository = clientRepository;
        }
    }

    public Client registerClient(Client client) {
       return client;
    }

    public void unregisterClient(Client client) {
        if(client != null) {
            client.setArchived(true);
        }
    }
}
