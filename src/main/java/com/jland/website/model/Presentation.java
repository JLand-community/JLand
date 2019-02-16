package com.jland.website.model;

import java.util.List;
import java.util.Objects;

public class Presentation {

    private long id;
    private Event event;
    private String name;
    private List<PresentationPlanItem> presentationPlan;
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

    public List<PresentationPlanItem> getPresentationPlan() {
        return presentationPlan;
    }

    public void setPresentationPlan(List<PresentationPlanItem> presentationPlan) {
        this.presentationPlan = presentationPlan;
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
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "event=" + event +
                ", name='" + name + '\'' +
                ", presentationPlan=" + presentationPlan +
                ", user=" + user +
                '}';
    }
}