package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import managers.SportCentre;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "volleyball_field")

public class VolleyballField extends SportField implements Serializable {
    @Column(name = "net_height")
    private double netHeight;

    public VolleyballField(String surface, String discipline, SportCentre sportCentre, double netHeight) {
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
