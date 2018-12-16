package com.jland.repository.impl;

import com.jland.model.Conference;
import com.jland.repository.ConferenceRepository;
import com.jland.repository.mapper.ConferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceRepositoryImpl implements ConferenceRepository {

    private static final ConferenceMapper conferenceMapper = new ConferenceMapper();
    private static final String GET_CONFERENCE_SQL = "select id, description, date, address from conference where id = :id;";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ConferenceRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Conference getConferenceById(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter =new MapSqlParameterSource();
        mapSqlParameter.addValue("id", conferenceId);
        return namedParameterJdbcTemplate.queryForObject(GET_CONFERENCE_SQL, mapSqlParameter, conferenceMapper);
    }
}
