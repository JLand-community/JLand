package com.jland.website.repository.mapper;

import com.jland.website.model.Participant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipantMapper implements RowMapper<Participant> {

    private UserMapper userMapper;

    public ParticipantMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Participant mapRow(ResultSet resultSet, int i) throws SQLException {
        Participant participant = new Participant();
        participant.setId(resultSet.getLong("participant_id"));
        participant.setUser(userMapper.mapRow(resultSet,i));
        return participant;
    }
}
