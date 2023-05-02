package repositories;

import model.Client;
import model.PrivatePerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientRepositoryTest {
    ClientRepository cr = new ClientRepository("mongodb://hardkorowy-koxu:eJ8LsRoGZQvGhkvnW9PQAYZ2f9zXPaaaAlk98Ok5nrkXRuadxOlz4P499A2YbSl4D1km1vW7GoHfACDbM2Gbvw==@hardkorowy-koxu.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@hardkorowy-koxu@");
    Client client = new PrivatePerson("123a3123", 11992, "Wdaiktor", "Malavasi");

    @Test
    void addTest() {
        cr.add(client);
        Assertions.assertEquals(client.getPhoneNumber(), cr.get(client.getClientId()).getPhoneNumber());
        Assertions.assertEquals(client.getNumberOfPlayers(), cr.get(client.getClientId()).getNumberOfPlayers());
        cr.remove(client.getClientId());
    }

    @Test
    void removeTest() {
        cr.add(client);
        cr.remove(client.getClientId());
        Assertions.assertNull(cr.get(client.getClientId()));
    }

    @Test
    void getTest() {
        cr.add(client);
        Assertions.assertNotNull(cr.get(client.getClientId()));
    }

    @Test
    void updateTest() {
        cr.add(client);
        client.setPhoneNumber("1420");
        cr.update(client);
        Assertions.assertEquals(client.getPhoneNumber(), cr.get(client.getClientId()).getPhoneNumber());
    }
}
