package model;

import Utils.GsonUtils;
import Utils.RuntimeTypeAdapterFactory;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbSubtype;
import jakarta.json.bind.annotation.JsonbTypeInfo;
import jakarta.persistence.*;
import managers.SportCentre;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;


@BsonDiscriminator(key = "type", value = "SportFieldDisc")
@JsonbTypeInfo(key = "SportField", value = {@JsonbSubtype(alias = "FootballField", type = FootballField.class), @JsonbSubtype(alias = "Volleyball", type = VolleyballField.class), @JsonbSubtype(alias = "BasketballField", type = BasketballField.class)})
public abstract class SportField implements Serializable {

    @BsonId
    @JsonbProperty("id")
    private final String sportFieldId;

    @BsonProperty("surface")
    @JsonbProperty("surface")
    private String surface;

    @BsonProperty("discipline")
    @JsonbProperty("discipline")
    private String discipline;

    @BsonProperty("archived")
    @JsonbProperty("archived")
    private Boolean archived = false;

    private static final RuntimeTypeAdapterFactory<SportField> adapter =
            RuntimeTypeAdapterFactory.of(SportField.class);

    private static final HashSet<Class<?>> registeredClasses= new HashSet<Class<?>>();

    static {
        GsonUtils.registerType(adapter);
    }

    private synchronized void registerClass() {
        if (!registeredClasses.contains(this.getClass())) {
            registeredClasses.add(this.getClass());
            adapter.registerSubtype(this.getClass());
        }
    }


    public SportField(String surface, String discipline) {
        registerClass();
        this.sportFieldId = UUID.randomUUID().toString();
        this.surface = surface;
        this.discipline = discipline;
    }

    @BsonCreator
    @JsonbCreator
    public SportField(@BsonProperty("surface") @JsonbProperty("surface") String surface, @BsonProperty("discipline") @JsonbProperty("discipline") String discipline, @BsonId @JsonbProperty("id") String id) {
        this.sportFieldId = id;
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

}
