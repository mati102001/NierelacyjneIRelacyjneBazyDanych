package model;

import jakarta.persistence.*;
import managers.SportCentre;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)


public abstract class SportField implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SportField that = (SportField) o;

        return new EqualsBuilder().append(id, that.id).append(sportFieldId, that.sportFieldId).append(surface, that.surface).append(discipline, that.discipline).append(archived, that.archived).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(sportFieldId).append(surface).append(discipline).append(archived).toHashCode();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sport_field_id", unique = true)
    private final String sportFieldId;

    @Column(name = "surface")
    private String surface;

    @Column(name = "discipline")
    private String discipline;

    @Column(name = "archived")
    private Boolean archived = false;

    public SportField(String surface, String discipline) {
        this.sportFieldId = UUID.randomUUID().toString();
        this.surface = surface;
        this.discipline = discipline;
    }

    public SportField() {
        this.sportFieldId = UUID.randomUUID().toString();
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getSportFieldId() {
        return sportFieldId;
    }

    public long getId() {
        return id;
    }

}
