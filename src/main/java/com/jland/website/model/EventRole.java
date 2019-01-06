package com.jland.website.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum EventRole {
    SPEAKER("Speaker"),
    LISTENER("Listener");

    private final String value;

    EventRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventRole getEventRole(String role) {
        for (EventRole eventRole : values()) {
            if (eventRole.getValue().equalsIgnoreCase(role)) {
                return eventRole;
            }
        }
        throw new RuntimeException("Incorrect event role " + role);
    }
}
