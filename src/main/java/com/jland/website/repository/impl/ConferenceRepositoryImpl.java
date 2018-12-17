package com.jland.website.repository.impl;

import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import com.jland.website.repository.mapper.ConferenceMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceRepositoryImpl implements ConferenceRepository {

    private static final ConferenceMapper conferenceMapper = new ConferenceMapper();
    private static final String GET_CONFERENCE_SQL = "select id, description, date, address from conference where id = :id;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
