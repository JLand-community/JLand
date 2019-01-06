package com.jland.website.repository.mapper;

import com.jland.website.model.Conference;
import com.jland.website.model.EventRole;
import com.jland.website.model.Participation;
import com.jland.website.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ParticipationMapperTest {

    @Mock
    private ResultSet resultSet;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    void mapRow() throws SQLException {
        //GIVEN
        Participation expectedParticipation = new Participation();
        expectedParticipation.setId(1L);
        expectedParticipation.setEventRole(EventRole.LISTENER);
        expectedParticipation.setUser(new User("first", "last"));
        expectedParticipation.setConference(new Conference(1L, "event", LocalDate.of(2019, 01, 19), "address"));

        when(resultSet.getLong("id")).thenReturn(1L);
        when(resultSet.getLong("conference_id")).thenReturn(1L);
        when(resultSet.getString("event_role")).thenReturn("listener");
        when(userMapper.mapRow(resultSet, 0)).thenReturn(new User("first", "last"));
        when(resultSet.getString("description")).thenReturn("event");
        when(resultSet.getDate("date")).thenReturn(Date.valueOf("2019-01-19"));
        when(resultSet.getString("address")).thenReturn("address");

        ParticipationMapper mapper = new ParticipationMapper(userMapper);
        //WHEN
        Participation participation = mapper.mapRow(resultSet, 0);
        //THEN
        Assertions.assertThat(participation).isEqualToComparingOnlyGivenFields(expectedParticipation);
    }
}