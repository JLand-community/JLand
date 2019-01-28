package com.jland.website.repository.jdbc;

import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import com.jland.website.repository.mapper.ConferenceMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ConferenceRepositoryJdbc implements ConferenceRepository {

    private static final ConferenceMapper conferenceMapper = new ConferenceMapper();
    private static final String GET_CONFERENCE_SQL = "select id, description, date, address from jland_site.conference where id = :id;";
    private static final String GET_CONFERENCE_BY_MAX_ID_SQL = "select id, description, date, address from jland_site.conference where id = (select max(id) from jland_site.conference);";


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ConferenceRepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<Conference> getById(Long id) {
        MapSqlParameterSource mapSqlParameter =new MapSqlParameterSource();
        mapSqlParameter.addValue("id", id);
        return namedParameterJdbcTemplate.query(GET_CONFERENCE_SQL, mapSqlParameter, conferenceMapper).stream().findFirst();
    }

    @Override
    public Optional<Conference> getNearestConference() {
        return namedParameterJdbcTemplate.query(GET_CONFERENCE_BY_MAX_ID_SQL, conferenceMapper).stream().findFirst();
    }




}
