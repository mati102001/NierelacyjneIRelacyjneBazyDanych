package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;

import java.io.Serializable;

@Entity(defaultKeyspace = "rent_orlik")
@CqlName("fields")
@PropertyStrategy(mutable = false)
public class SportField implements Serializable {
    @PartitionKey
    @CqlName("id")
    private String id;

    @CqlName("type")
    private String type;

    @CqlName("surface")
    private String surface;

    public SportField() {
    }

    public SportField(String id, String type, String surface) {
        this.id = id;
        this.type = type;
        this.surface = surface;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}
