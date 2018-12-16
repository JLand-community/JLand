package com.jland.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jland.model.serializer.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class Conference {

    private long id;
    private String description;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conference)) return false;
        Conference that = (Conference) o;
        return Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDescription(), getDate(), getAddress());
    }

    @Override
    public String toString() {
        return "Conference{" +
                "description='" + description + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}
