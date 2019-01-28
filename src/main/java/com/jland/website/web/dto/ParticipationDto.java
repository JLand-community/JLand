package com.jland.website.web.dto;

import com.jland.website.model.Participant;

public class ParticipationDto {

    private String firstName;
    private String lastName;
    private String eventRole;

    public ParticipationDto() {
    }

    public ParticipationDto(String firstName, String lastName, String eventRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eventRole = eventRole;
    }

    public static ParticipationDto from(Participant participant) {
        return  new ParticipationDto(
                participant.getUser().getFirstName(),
                participant.getUser().getLastName(),
                participant.getEventRole().getValue());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEventRole() {
        return eventRole;
    }

    public void setEventRole(String eventRole) {
        this.eventRole = eventRole;
    }

    @Override
    public String toString() {
        return "ParticipationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eventRole=" + eventRole +
                '}';
    }
}
