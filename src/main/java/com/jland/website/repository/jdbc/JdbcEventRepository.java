package com.jland.website.repository.jdbc;

import com.jland.website.model.Event;
import com.jland.website.repository.EventRepository;
import com.jland.website.repository.mapper.EventMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcEventRepository implements EventRepository {

    private static final EventMapper eventMapper = new EventMapper();
    private static final String GET_CONFERENCE_EVENTS_SQL =
            "SELECT e.id event_id, e.type, e.start_time, e.end_time, e.name, u.first_name, u.last_name, p.id presentation_id, p.name presentation_name \n"+
            "FROM jland_site.event e\n"+
            "LEFT JOIN jland_site.presentation p ON p.event_id = e.id\n"+
            "LEFT JOIN jland_site.user u ON u.id = p.user_id\n"+
            "where e.conference_id = :conference_id\n"+
            "order by e.event_order asc;";


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcEventRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public List<Event> getAllByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(GET_CONFERENCE_EVENTS_SQL, mapSqlParameter, eventMapper);
    }

}
