package com.jland.website.repository.mapper;

import com.jland.website.constants.ConferenceAgendaEventType;
import com.jland.website.model.Event;
import com.jland.website.model.Presentation;
import com.jland.website.model.PresentationEvent;
import com.jland.website.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {

        String type = resultSet.getString("type").toUpperCase();

        if(!ConferenceAgendaEventType.PRESENTATION.name().equals(type)){
            return getEvent(resultSet, new Event());
        }

        PresentationEvent presentationEvent = (PresentationEvent) getEvent(resultSet, new PresentationEvent()) ;
        presentationEvent.setPresentationId(resultSet.getLong("presentation_id"));
        presentationEvent.setPresentationName(resultSet.getString("presentation_name"));
        presentationEvent.setUserFirstName(resultSet.getString("first_name"));
        presentationEvent.setUserLastName(resultSet.getString("last_name"));
        return presentationEvent;

    }

    private Event getEvent(ResultSet resultSet, Event event) throws SQLException {
        event.setId(resultSet.getLong("event_id"));
        event.setName(resultSet.getString("name"));
        event.setType(resultSet.getString("type"));
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        event.setStartTime(startTime);
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        event.setEndTime(endTime);
        event.setOrder(resultSet.getInt("event_order"));
        return event;
    }

}
