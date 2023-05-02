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
        Client newClient = clientRepository.get(client.getId());
        if(newClient == null) {
            clientRepository.add(client);
            return client;
        } else {
            newClient.setArchived(false);
            return newClient;
        }
    }

    public void unregisterClient(Client client) {
        if(client != null) {
            client.setArchived(true);
        }
    }
}
