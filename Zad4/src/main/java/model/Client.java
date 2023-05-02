package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import java.io.Serializable;

@Entity(defaultKeyspace = "rent_orlik")
@CqlName("clients")
public class Client implements Serializable {

    @CqlName("first_name")
    private String firstName;

    @CqlName("last_name")
    private String lastName;

    @PartitionKey
    @CqlName("id")
    private String id;

    @CqlName("age")
    private int age;


    public Client() {
    }

    public Client(String firstName,
                  String lastName,
                  String id,
                  int age
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
