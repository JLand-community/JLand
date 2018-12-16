package com.jland.model;

import java.util.List;
import java.util.Objects;

public class Presentation {

    private long id;
    private Event event;
    private String name;
    private List<PresentationPlan> items;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PresentationPlan> getItems() {
        return items;
    }

    public void setItems(List<PresentationPlan> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Presentation)) return false;
        Presentation that = (Presentation) o;
        return Objects.equals(getEvent(), that.getEvent()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getItems(), that.getItems()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEvent(), getName(), getItems(), getUser());
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "event=" + event +
                ", name='" + name + '\'' +
                ", items=" + items +
                ", user=" + user +
                '}';
    }
}