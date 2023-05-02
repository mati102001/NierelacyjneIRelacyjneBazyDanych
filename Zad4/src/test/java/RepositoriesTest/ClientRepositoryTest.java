package RepositoriesTest;

import Repository.Client.ClientRepository;
import model.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.*;

public class ClientRepositoryTest {
    ClientRepository clientRepository;

    Client client1;

    Client client2;

    @Before
    public void init() {
        clientRepository = new ClientRepository();

        client1 = new Client("Arnold", "Boczek", "111111111", 45);
        client2 = new Client("Marian", "Pazdzioch", "222222222", 79);

        clientRepository.add(client1);
        clientRepository.add(client2);
    }

    @Test
    public void getClientByPersonalIdTest() {
        Client clientFromRepo = clientRepository.getClientByPersonalId(client1.getId());
        assertEquals(clientFromRepo.getFirstName(), client1.getFirstName());
    }

    @Test
    public void findAllClientsTest() {
        assertNotNull(clientRepository.getAllClients());
    }

    @Test(expected = NullPointerException.class)
    public void deleteTest() {
        clientRepository.removeById(client1.getId());
        clientRepository.get(client1.getId());
    }

    @Test
    public void updateTest() {
        Client client = clientRepository.getClientByPersonalId(client2.getId());
        client.setFirstName("JuzNieJanusz");
        clientRepository.update(client);
        assertEquals("JuzNieJanusz", clientRepository.getClientByPersonalId(client2.getId()).getFirstName());
    }
}
