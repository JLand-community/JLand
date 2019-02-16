package com.jland.website.repository.mapper;

import com.jland.website.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import static org.mockito.Mockito.when;


class EventMapperTest {

    private ResultSet resultSet = Mockito.mock(ResultSet.class);

    @Test
    void mapRow() throws SQLException {

        /*Agenda item is a presentation*/
        when(resultSet.getLong("event_id")).thenReturn(100L);
        when(resultSet.getString("name")).thenReturn("PresentationName");
        when(resultSet.getString("type")).thenReturn("Presentation");
        when(resultSet.getTime("start_time")).thenReturn(Time.valueOf(LocalTime.of(11, 0)));
        when(resultSet.getTime("end_time")).thenReturn(Time.valueOf(LocalTime.of(12, 0)));
        when(resultSet.getString("first_name")).thenReturn("FirstName");
        when(resultSet.getString("last_name")).thenReturn("LastName");
        when(resultSet.getLong("presentation_id")).thenReturn(1L);
        when(resultSet.getString("presentation_name")).thenReturn("PresentationName");

        EventMapper mapper = new EventMapper();
        Event event = mapper.mapRow(resultSet, 0);
        Assertions.assertEquals(100L, event.getId());
        Assertions.assertEquals("PresentationName", event.getName());
        Assertions.assertEquals("Presentation", event.getType());
        Assertions.assertEquals(LocalTime.of(11, 0), event.getStartTime());
        Assertions.assertEquals(LocalTime.of(12, 0), event.getEndTime());
        Assertions.assertEquals(1L, event.getPresentation().getId());
        Assertions.assertEquals("PresentationName", event.getPresentation().getName());
        Assertions.assertEquals("FirstName", event.getPresentation().getUser().getFirstName());
        Assertions.assertEquals("LastName", event.getPresentation().getUser().getLastName());

        /*Agenda item is a break*/
        when(resultSet.getLong("event_id")).thenReturn(200L);
        when(resultSet.getString("name")).thenReturn("Welcome Coffee");
        when(resultSet.getString("type")).thenReturn("Coffee");
        when(resultSet.getTime("start_time")).thenReturn(Time.valueOf(LocalTime.of(16, 0)));
        when(resultSet.getTime("end_time")).thenReturn(Time.valueOf(LocalTime.of(18, 0)));
        when(resultSet.getString("first_name")).thenReturn(null);
        when(resultSet.getString("last_name")).thenReturn(null);
        when(resultSet.getLong("presentation_id")).thenReturn(0L);
        when(resultSet.getString("presentation_name")).thenReturn(null);

        EventMapper mapperCoffee = new EventMapper();
        Event eventCoffee = mapperCoffee.mapRow(resultSet, 0);
        Assertions.assertEquals(200L, eventCoffee.getId());
        Assertions.assertEquals("Welcome Coffee", eventCoffee.getName());
        Assertions.assertEquals("Coffee", eventCoffee.getType());
        Assertions.assertEquals(LocalTime.of(16, 0), eventCoffee.getStartTime());
        Assertions.assertEquals(LocalTime.of(18, 0), eventCoffee.getEndTime());
        Assertions.assertEquals(0, eventCoffee.getPresentation().getId());
        Assertions.assertEquals(null, eventCoffee.getPresentation().getName());
        Assertions.assertEquals(null, eventCoffee.getPresentation().getUser().getFirstName());
        Assertions.assertEquals(null, eventCoffee.getPresentation().getUser().getLastName());

    }

}