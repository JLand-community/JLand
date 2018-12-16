package com.jland.repository.impl;

import com.jland.model.Presentation;
import com.jland.repository.PresentationRepository;
import com.jland.repository.mapper.PresentationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PresentationRepositoryImpl implements PresentationRepository {

    private static final PresentationMapper presentationMapper = new PresentationMapper();
    private static final String GET_ALL_PRESENTATIONS_SQL = "select e.id event_id, p.id presentation_id, e.name event_name, p.name presentation_name, e.type, e.start_time, e.end_time, u.first_name, u.last_name" +
            " from event e left join presentation p on e.id=p.event_id join user u" +
            " on p.user_id=u.id where e.conference_id =  :conference_id order by e.order asc;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PresentationRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Presentation> getPresentationsByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(GET_ALL_PRESENTATIONS_SQL, mapSqlParameter, presentationMapper);
    }
}
