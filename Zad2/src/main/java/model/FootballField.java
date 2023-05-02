package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import managers.SportCentre;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@BsonDiscriminator(key = "type", value = "foot")

public class FootballField extends SportField implements Serializable {

    @BsonProperty("gate_dimension")
    private String footballGateDimension;

    @BsonCreator
    public FootballField(@BsonProperty("surface") String surface, @BsonProperty("discipline") String discipline, @BsonProperty("gate_dimension") String footballGateDimension, @BsonId String id) {
        super(surface, discipline, id);
        this.footballGateDimension = footballGateDimension;
    }


    public FootballField(String surface, String discipline, String footballGateDimension) {
        super(surface, discipline);
        this.footballGateDimension = footballGateDimension;
    }

    public String getFootballGateDimension() {
        return footballGateDimension;
    }

    public void setFootballGateDimension(String footballGateDimension) {
        this.footballGateDimension = footballGateDimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FootballField that = (FootballField) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(footballGateDimension, that.footballGateDimension).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(footballGateDimension).toHashCode();
    }
}
