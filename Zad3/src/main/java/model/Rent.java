package model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Rent implements Serializable {

    @BsonId
    @JsonbProperty("id")
    private String rentId;

    @BsonProperty("date")
    @JsonbProperty("date")
    private LocalDate date;

    @BsonProperty("begin_time")
    @JsonbProperty("begin_time")
    private LocalTime beginTime;

    @BsonProperty("end_time")
    @JsonbProperty("end_time")
    private LocalTime endTime;

    @BsonProperty(value = "client_id", useDiscriminator = true)
    @JsonbProperty("client")
    private Client client;

    @BsonProperty(value = "field", useDiscriminator = true)
    @JsonbProperty("field")
    private SportField field;

    @BsonProperty("archived")
    @JsonbProperty("archived")
    private boolean archived = false;

    public Rent() {
    }

    public Rent(LocalDate date, LocalTime beginTime, LocalTime endTime, Client client, SportField field) {
        this.rentId = UUID.randomUUID().toString();
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.client = client;
        this.field = field;
    }

    @JsonbCreator
    @BsonCreator
    public Rent(@BsonProperty("date") @JsonbProperty("date") LocalDate date,@BsonProperty("begin_time") @JsonbProperty("begin_time") LocalTime beginTime,@BsonProperty("end_time") @JsonbProperty("end_time") LocalTime endTime,@BsonProperty("client") @JsonbProperty("client") Client client, @BsonProperty("field_id") @JsonbProperty("field") SportField field, @BsonId @BsonProperty("id") String id) {
        this.rentId = id;
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.client = client;
        this.field = field;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getRentId() {
        return rentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("rentId", rentId)
                .append("date", date)
                .append("beginTime", beginTime)
                .append("endTime", endTime)
                .append("client", client)
                .append("field", field)
                .append("archived", archived)
                .toString();
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public SportField getField() {
        return field;
    }

    public void setField(SportField field) {
        this.field = field;
    }
}
