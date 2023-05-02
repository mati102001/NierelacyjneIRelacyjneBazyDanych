import Repository.Client.ClientRepository;
import Repository.SportField.SportFieldRepository;
import model.Client;
import model.SportField;

public class Main {

    public static void main(String[] args) {

        ClientRepository clientRepository;
        SportFieldRepository fr;
        clientRepository = new ClientRepository();
        fr = new SportFieldRepository();
        Client client1 = new Client("Twoja", "Matka", "12345678911", 21);
        SportField field = new SportField("666666", "twoj", "stary");



        fr.add(field);

    }

}
