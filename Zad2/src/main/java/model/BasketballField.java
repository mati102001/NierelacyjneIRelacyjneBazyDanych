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

@BsonDiscriminator(key = "type", value = "basketBallField")

public class BasketballField extends SportField implements Serializable {

    @BsonProperty("basket_height")
    private double basketHeight;

    @BsonCreator
    public BasketballField(@BsonProperty("surface") String surface, @BsonProperty("discipline") String discipline, @BsonProperty("basket_height") double basketHeight, @BsonId String id) {
        super(surface, discipline, id);
        this.basketHeight = basketHeight;
    }

    public BasketballField(String surface, String discipline, double basketHeight) {
        super(surface, discipline);
        this.basketHeight = basketHeight;
    }

    public double getBasketHeight() {
        return basketHeight;
    }

    public void setBasketHeight(double basketHeight) {
        this.basketHeight = basketHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BasketballField that = (BasketballField) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(basketHeight, that.basketHeight).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(basketHeight).toHashCode();
    }
}
