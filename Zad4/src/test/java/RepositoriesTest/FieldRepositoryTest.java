package RepositoriesTest;

import Repository.Client.ClientRepository;
import Repository.SportField.SportFieldRepository;
import model.Client;
import model.SportField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldRepositoryTest {
    SportFieldRepository fieldRepository;

    SportField field1;

    SportField field2;

    @Before
    public void init() {
        fieldRepository = new SportFieldRepository();

        field1 = new SportField("111111111", "kosz", "guma");
        field2 = new SportField("222222222", "gala", "trawa");

        fieldRepository.add(field1);
        fieldRepository.add(field2);
    }

    @Test
    public void getFieldByIdTest() {
        SportField newField = fieldRepository.getSportFieldById(field1.getId());
        assertEquals(newField.getSurface(), field1.getSurface());
    }

    @Test
    public void findAllClientsTest() {
        assertNotNull(fieldRepository.getAllFields());
    }

    @Test(expected = NullPointerException.class)
    public void deleteTest() {
        fieldRepository.removeById(field1.getId());
        fieldRepository.get(field1.getId());
    }

    @Test
    public void updateTest() {
        SportField field = fieldRepository.getSportFieldById(field1.getId());
        field.setSurface("beton");
        fieldRepository.update(field);
        assertEquals("beton", fieldRepository.getSportFieldById(field1.getId()).getSurface());
    }
}
