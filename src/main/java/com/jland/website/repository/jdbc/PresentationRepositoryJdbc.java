package com.jland.website.repository.jdbc;

import com.jland.website.model.Presentation;
import com.jland.website.repository.PresentationRepository;
import com.jland.website.repository.mapper.PresentationMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PresentationRepositoryJdbc implements PresentationRepository {

    private static final PresentationMapper presentationMapper = new PresentationMapper();
    private static final String GET_ALL_PRESENTATIONS_SQL = "select e.id event_id, p.id presentation_id, e.name event_name, p.name presentation_name, e.type, e.start_time, e.end_time, u.first_name, u.last_name" +
            " from event e left join presentation p on e.id=p.event_id join user u" +
            " on p.user_id=u.id where e.conference_id =  :conference_id order by e.order asc;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PresentationRepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Presentation> getAllByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(GET_ALL_PRESENTATIONS_SQL, mapSqlParameter, presentationMapper);
    }
}