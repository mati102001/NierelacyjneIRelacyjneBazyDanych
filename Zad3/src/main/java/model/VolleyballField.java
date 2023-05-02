package model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
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


@BsonDiscriminator(key = "type", value = "volleyBallField")
public class VolleyballField extends SportField implements Serializable {

    @BsonProperty("net_height")
    @JsonbProperty("net_height")
    private double netHeight;

    @BsonCreator
    @JsonbCreator
    public VolleyballField(@BsonProperty("surface") @JsonbProperty("surface") String surface, @BsonProperty("discipline") @JsonbProperty("discipline") String discipline, @BsonProperty("net_height") @JsonbProperty("net_height") double netHeight, @BsonId @BsonProperty("id") String id) {
        super(surface, discipline, id);
        this.netHeight = netHeight;
    }


    public VolleyballField(String surface, String discipline, double netHeight) {
        super(surface, discipline);
        this.netHeight = netHeight;
    }

    public VolleyballField() {}

    public double getNetHeight() {
        return netHeight;
    }

    public void setNetHeight(double netHeight) {
        this.netHeight = netHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        VolleyballField that = (VolleyballField) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(netHeight, that.netHeight).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(netHeight).toHashCode();
    }
}
