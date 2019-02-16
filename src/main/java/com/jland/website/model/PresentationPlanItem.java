package com.jland.website.model;

import java.util.Objects;

public class PresentationPlanItem {

    private long id;
    private String item;
    private int order;

    public PresentationPlanItem() {
    }

    public PresentationPlanItem(String item, int order) {
        this.item = item;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PresentationPlanItem)) return false;
        PresentationPlanItem point = (PresentationPlanItem) o;
        return getOrder() == point.getOrder() &&
                Objects.equals(getId(), point.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Point{" +
                "item='" + item + '\'' +
                ", order=" + order +
                '}';
    }
}
