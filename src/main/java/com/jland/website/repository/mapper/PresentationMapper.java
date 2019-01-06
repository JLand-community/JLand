package com.jland.website.repository.mapper;

import com.jland.website.model.Event;
import com.jland.website.model.Presentation;
import com.jland.website.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class PresentationMapper implements RowMapper<Presentation> {

    private UserMapper userMapper;

    @Autowired
    public PresentationMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Presentation mapRow(ResultSet resultSet, int i) throws SQLException {
        Presentation presentation = new Presentation();
        presentation.setId(resultSet.getLong("presentation_id"));
        presentation.setName(resultSet.getString("presentation_name"));
        Event event = getEvent(resultSet);
        presentation.setEvent(event);
        User user = userMapper.mapRow(resultSet, i);
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
}
