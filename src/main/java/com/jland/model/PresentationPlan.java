package com.jland.model;

import java.util.Objects;

public class PresentationPlan {

    private long id;
    private String item;
    private int order;

    public PresentationPlan() {
    }

    public PresentationPlan(String item, int order) {
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
        if (!(o instanceof PresentationPlan)) return false;
        PresentationPlan point = (PresentationPlan) o;
        return getOrder() == point.getOrder() &&
                Objects.equals(getItem(), point.getItem());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getItem(), getOrder());
    }

    @Override
    public String toString() {
        return "Point{" +
                "item='" + item + '\'' +
                ", order=" + order +
                '}';
    }
}
