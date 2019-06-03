package com.jland.website.repository.jdbc;

import com.jland.website.model.Event;
import com.jland.website.repository.EventRepository;
import com.jland.website.repository.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcEventRepository implements EventRepository {

    private final EventMapper eventMapper = new EventMapper();
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String getEventsByConferenceIdSql;

    public JdbcEventRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public List<Event> getAllByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(getEventsByConferenceIdSql, mapSqlParameter, eventMapper);
    }

    @Autowired
    public void setGetEventsByConferenceIdSql(String getEventsByConferenceIdSql) {
        this.getEventsByConferenceIdSql = getEventsByConferenceIdSql;
    }

}
