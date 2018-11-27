package com.jland.model;

import java.util.List;
import java.util.Objects;

public class Presentation {

    private long id;
    private String name;
    private List<Point> points;
    private User user;

    public Presentation() {
    }

    public Presentation(String name, List<Point> points, User user) {
        this.name = name;
        this.points = points;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
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
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPoints(), that.getPoints()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getPoints(), getUser());
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", user=" + user +
                '}';
    }
}
