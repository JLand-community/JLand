package com.jland.website.model;

public class PresentationEvent extends Event {

    private long presentationId;
    private String presentationName;
    private String userFirstName;
    private String userLastName;

    public long getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(long presentationId) {
        this.presentationId = presentationId;
    }

    public String getPresentationName() {
        return presentationName;
    }

    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Override
    public String toString() {
        return super.toString() + "PresentationEvent{" +
                "presentationId=" + presentationId +
                ", presentationName='" + presentationName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
