package repositories;

import model.BasketballField;
import model.SportField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldRepositoryTest {
    SportCentreRepository scr = new SportCentreRepository("mongodb://hardkorowy-koxu:eJ8LsRoGZQvGhkvnW9PQAYZ2f9zXPaaaAlk98Ok5nrkXRuadxOlz4P499A2YbSl4D1km1vW7GoHfACDbM2Gbvw==@hardkorowy-koxu.mongo.cosmos.azure.com:10255/?ssl=true&retrywrites=false&replicaSet=globaldb&maxIdleTimeMS=120000&appName=@hardkorowy-koxu@");
    SportField field = new BasketballField("dsaddas", "adasdasd", 2137);

    @Test
    void addTest() {
        scr.add(field);
        Assertions.assertEquals(field.getSurface(), scr.get(field.getSportFieldId()).getSurface());
        Assertions.assertEquals(field.getDiscipline(), scr.get(field.getSportFieldId()).getDiscipline());
        scr.remove(field.getSportFieldId());
    }

    @Test
    void removeTest() {
        scr.add(field);
        scr.remove(field.getSportFieldId());
        Assertions.assertNull(scr.get(field.getSportFieldId()));
    }

    @Test
    void getTest() {
        scr.add(field);
        Assertions.assertNotNull(scr.get(field.getSportFieldId()));
    }

    @Test
    void updateTest() {
        scr.add(field);
        field.setSurface("gum");
        scr.update(field);
        Assertions.assertEquals(field.getSurface(), scr.get(field.getSportFieldId()).getSurface());
    }
}
