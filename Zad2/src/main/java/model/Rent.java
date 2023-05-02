package model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Rent implements Serializable {

    @BsonId
    private String rentId;

    @BsonProperty("date")
    private LocalDate date;

    @BsonProperty("begin_time")
    private LocalTime beginTime;

    @BsonProperty("end_time")
    private LocalTime endTime;

    @BsonProperty(value = "client", useDiscriminator = true)
    Client client;

    @BsonProperty(value = "field", useDiscriminator = true)
    SportField field;

    @BsonProperty("archived")
    private boolean archived = false;

    @BsonCreator
    public Rent(@BsonProperty("date") LocalDate date,@BsonProperty("begin_time") LocalTime beginTime,@BsonProperty("end_time") LocalTime endTime,@BsonProperty("client") Client client, @BsonProperty("field") SportField field) {
        rentId = UUID.randomUUID().toString();
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.client = client;
        this.field = field;
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

    public Client getClient() {
        return client;
    }

    public SportField getField() {
        return field;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setField(SportField field) {
        this.field = field;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
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
}
