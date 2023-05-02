package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity(defaultKeyspace = "rent_orlik")
@CqlName("rents")
public class Rent implements Serializable {

    @PartitionKey
    @CqlName("id")
    private String id;

    @CqlName("start")
    private LocalTime start;

    @CqlName("end")
    private LocalTime end;

    @CqlName("date")
    private LocalDate date;

    @CqlName("client_id")
    private String clientId;

    @CqlName("field_id")
    private String fieldId;

    public Rent() {
    }

    public Rent(String id, LocalTime start, LocalTime end, LocalDate date, String clientId, String fieldId) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.date = date;
        this.clientId = clientId;
        this.fieldId = fieldId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
}
