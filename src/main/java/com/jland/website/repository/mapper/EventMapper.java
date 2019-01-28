package com.jland.website.repository.mapper;

import com.jland.website.model.Event;
import com.jland.website.model.Presentation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet resultSet, int i) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getLong("event_id"));
        event.setName(resultSet.getString("name"));
        event.setType(resultSet.getString("type"));
        LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
        event.setStartTime(startTime);
        LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
        event.setEndTime(endTime);

        Presentation presentation = getPresentation(resultSet, i);

        event.setPresentation(presentation);
        return event;
    }

    private Presentation getPresentation(ResultSet resultSet, int i) throws SQLException {
        PresentationMapper presentationMapper = new PresentationMapper();
        return presentationMapper.mapRow(resultSet,i);
    }


}
