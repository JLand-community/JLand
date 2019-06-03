package com.jland.website.model;

import java.util.List;
import java.util.Objects;

public class Presentation {

    private long id;
    private String name;
    private List<PresentationPlanItem> presentationPlan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPresentationPlan(List<PresentationPlanItem> presentationPlan) {
        this.presentationPlan = presentationPlan;
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
                ", name='" + name + '\'' +
                ", presentationPlan=" + presentationPlan +
                '}';
    }
}