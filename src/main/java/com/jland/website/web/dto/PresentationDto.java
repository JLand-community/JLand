package com.jland.website.web.dto;

import com.jland.website.model.Presentation;

public class PresentationDto {

    private String presentationName;
    private String userFirstName;
    private String userLastName;

    public PresentationDto(String presentationName, String userFirstName, String userLastName) {
        this.presentationName = presentationName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public PresentationDto() {

    }

    public static PresentationDto from(Presentation presentation) {
        return  new PresentationDto(
                presentation.getName(),
                presentation.getUser().getFirstName(),
                presentation.getUser().getLastName());
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
        return "PresentationDto{" +
                "presentationName='" + presentationName + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
