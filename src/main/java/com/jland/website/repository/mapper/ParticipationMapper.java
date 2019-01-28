package com.jland.website.repository.mapper;

import com.jland.website.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ParticipationMapper implements RowMapper<Participant> {


    private UserMapper userMapper;

    @Autowired
    public ParticipationMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Participant mapRow(ResultSet resultSet, int i) throws SQLException {
        Participant participant = new Participant();
        participant.setId(resultSet.getLong("id"));
        User user = userMapper.mapRow(resultSet, i);
        participant.setUser(user);
        Conference conference = getConference(resultSet);
        participant.setConference(conference);
        participant.setEventRole(EventRole.getEventRole(resultSet.getString("event_role")));
        return participant;
    }

    private Conference getConference(ResultSet resultSet) throws SQLException {
        Conference conference = new Conference();
        conference.setId(resultSet.getLong("conference_id"));
        conference.setDescription(resultSet.getString("description"));
        LocalDate date = resultSet.getDate("date").toLocalDate();
        conference.setDate(date);
        conference.setAddress(resultSet.getString("address"));
        return conference;
    }
}
