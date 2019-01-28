package com.jland.website.repository.mapper;

import com.jland.website.model.Presentation;
import com.jland.website.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PresentationMapperTest {

    @Mock
    private ResultSet resultSet;
    @Mock
    private UserMapper userMapper;

    @Test
    void mapRow() throws SQLException {
        //GIVEN
        when(resultSet.getLong("presentation_id")).thenReturn(1L);
        when(resultSet.getString("presentation_name")).thenReturn("presentation");
        when(resultSet.getLong("event_id")).thenReturn(2L);
        when(resultSet.getString("event_name")).thenReturn("event");
        when(resultSet.getString("type")).thenReturn("break");
        when(resultSet.getTime("start_time")).thenReturn(Time.valueOf(LocalTime.of(12, 0)));
        when(resultSet.getTime("end_time")).thenReturn(Time.valueOf(LocalTime.of(13, 0)));
        when(userMapper.mapRow(resultSet, 0)).thenReturn(new User("first", "last"));

        PresentationMapper mapper = new PresentationMapper(userMapper);
        //WHEN
        Presentation presentation = mapper.mapRow(resultSet, 0);
        //THEN
        Assertions.assertEquals(1L, presentation.getId());
        Assertions.assertEquals("presentation", presentation.getName());
        Assertions.assertEquals(2L, presentation.getEvent().getId());
        Assertions.assertEquals("event", presentation.getEvent().getName());
        Assertions.assertEquals("break", presentation.getEvent().getType());
        Assertions.assertEquals(LocalTime.of(12, 0), presentation.getEvent().getStartTime());
        Assertions.assertEquals(LocalTime.of(13, 0), presentation.getEvent().getEndTime());
        Assertions.assertEquals("first", presentation.getUser().getFirstName());
        Assertions.assertEquals("last", presentation.getUser().getLastName());
    }
}