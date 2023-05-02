package model;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)

public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "rent_id")
    private String rentId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "begin_time")
    private LocalTime beginTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //slajd 44
    @JoinColumn
    @NotNull
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) //slajd 44
    @JoinColumn
    @NotNull
    private SportField field;

    @Column(name = "is_archived")
    private boolean archived = false;

    public Rent(LocalDate date, LocalTime beginTime, LocalTime endTime, Client client, SportField field) {
        rentId = UUID.randomUUID().toString();
        this.date = date;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.client = client;
        this.field = field;
    }

    public Rent() {}

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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("rentId", rentId)
                .append("date", date)
                .append("beginTime", beginTime)
                .append("endTime", endTime)
                .append("client", client)
                .append("field", field)
                .append("archived", archived)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        return new EqualsBuilder().append(id, rent.id).append(archived, rent.archived).append(rentId, rent.rentId).append(date, rent.date).append(beginTime, rent.beginTime).append(endTime, rent.endTime).append(client, rent.client).append(field, rent.field).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(rentId).append(date).append(beginTime).append(endTime).append(client).append(field).append(archived).toHashCode();
    }


}
