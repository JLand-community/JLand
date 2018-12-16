package com.jland.repository.mapper;

import com.jland.model.Event;
import com.jland.model.Presentation;
import com.jland.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class PresentationMapper implements RowMapper<Presentation> {

    @Override
    public Presentation mapRow(ResultSet resultSet, int i) throws SQLException {
        Presentation presentation = new Presentation();
        presentation.setId(resultSet.getLong("presentation_id"));
        presentation.setName(resultSet.getString("presentation_name"));
        Event event = getEvent(resultSet);
        presentation.setEvent(event);
        User user = getUser(resultSet);
        presentation.setUser(user);
        return presentation;
    }

    private Event getEvent(ResultSet resultSet) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("event_id"));
        event.setName(resultSet.getString("event_name"));
        event.setType(resultSet.getString("type"));
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        event.setStartTime(startTime);
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        event.setEndTime(endTime);
        return event;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        return user;
    }

}
