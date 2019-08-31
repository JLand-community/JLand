package com.jland.website.repository.jdbc;

import com.jland.website.model.Conference;
import com.jland.website.repository.ConferenceRepository;
import com.jland.website.repository.jdbc.util.OptionalResultSetExtractor;
import com.jland.website.repository.mapper.ConferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcConferenceRepository implements ConferenceRepository {

    private final ConferenceMapper conferenceMapper = new ConferenceMapper();
    private final ResultSetExtractor<Optional<Conference>> extractor = new OptionalResultSetExtractor<>(conferenceMapper);

    private String getConferenceByIdSql;
    private String getUpcomingConferenceByMaxIdSql;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcConferenceRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<Conference> getById(Long id) {
        MapSqlParameterSource mapSqlParameter =new MapSqlParameterSource();
        mapSqlParameter.addValue("id", id);
        return namedParameterJdbcTemplate.query(getConferenceByIdSql, mapSqlParameter, extractor);
    }

    @Override
    public Optional<Conference> getUpcomingConference() {
        return namedParameterJdbcTemplate.query(getUpcomingConferenceByMaxIdSql, extractor);
    }

    @Autowired
    public void setGetConferenceByIdSql(String getConferenceByIdSql) {
        this.getConferenceByIdSql = getConferenceByIdSql;
    }
    @Autowired
    public void setGetUpcomingConferenceByMaxIdSql(String getUpcomingConferenceByMaxIdSql) {
        this.getUpcomingConferenceByMaxIdSql = getUpcomingConferenceByMaxIdSql;
    }



}
