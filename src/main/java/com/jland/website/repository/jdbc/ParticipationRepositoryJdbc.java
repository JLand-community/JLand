package com.jland.website.repository.jdbc;

import com.jland.website.model.Participation;
import com.jland.website.repository.ParticipationRepository;
import com.jland.website.repository.mapper.ParticipationMapper;
import com.jland.website.repository.mapper.UserMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipationRepositoryJdbc implements ParticipationRepository {

    private static final UserMapper USER_MAPPER = new UserMapper();
    private static final ParticipationMapper PARTICIPATION_MAPPER = new ParticipationMapper(USER_MAPPER);
    private static final String GET_ALL_PARTICIPATION_SQL = "select p.id, p.event_role, u.first_name, u.last_name, p.conference_id, c.description, c.date, c.address from jland_site.participant p join jland_site.user u on p.user_id = u.id join jland_site.conference c on p.conference_id=c.id where p.conference_id = :conference_id;";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ParticipationRepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Participation> getAllByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(GET_ALL_PARTICIPATION_SQL, mapSqlParameter, PARTICIPATION_MAPPER);
    }

    @Override
    public void addParticipant() {

    }
}
