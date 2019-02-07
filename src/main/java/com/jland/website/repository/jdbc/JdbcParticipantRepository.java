package com.jland.website.repository.jdbc;

import com.jland.website.model.Participant;
import com.jland.website.repository.ParticipantRepository;
import com.jland.website.repository.mapper.ParticipantMapper;
import com.jland.website.repository.mapper.UserMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class JdbcParticipantRepository implements ParticipantRepository {

    private final UserMapper userMapper = new UserMapper();
    private final ParticipantMapper participantMapper = new ParticipantMapper(userMapper);
    private static final String ADD_PARTICIPANT_SQL = "INSERT INTO jland_site.participant (user_id, conference_id) VALUES(:userId, :conferenceId);";
    private static final String REMOVE_PARTICIPANT_SQL = "DELETE FROM jland_site.participant WHERE user_id = :userId AND conference_id = :conferenceId;";
    private static final String GET_ALL_PARTICIPANT_SQL =
            "SELECT p.id participant_id,p.user_id user_id, u.first_name, u.last_name, u.photo, u.username, u.user_role, u.password\n" +
            "FROM jland_site.participant p\n" +
            "JOIN jland_site.user u ON p.user_id = u.id\n" +
            "WHERE p.conference_id = :conferenceId;";

    private static final String FIND_PARTICIPANT_SQL =
            "select p.id participant_id, p.user_id user_id,  u.first_name, u.last_name " +
            "from jland_site.participant p\n" +
            "join jland_site.user u on p.user_id = u.id where user_id = :userId and conference_id = :conferenceId;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcParticipantRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void participate(long userId, long conferenceId) {
        namedParameterJdbcTemplate.update(ADD_PARTICIPANT_SQL, getParameters(userId, conferenceId));
    }

    @Override
    public void notParticipate(long userId, long conferenceId) {
        namedParameterJdbcTemplate.update(REMOVE_PARTICIPANT_SQL, getParameters(userId, conferenceId));
    }

    @Override
    public Boolean isParticipant(long userId, long conferenceId) {
        ResultSetExtractor<Boolean> extractor = ResultSet::next;
        return namedParameterJdbcTemplate.query(FIND_PARTICIPANT_SQL, getParameters(userId, conferenceId), extractor);
}

    @Override
    public List<Participant> getAllByConferenceId(Long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conferenceId", conferenceId);
        return namedParameterJdbcTemplate.query(GET_ALL_PARTICIPANT_SQL, mapSqlParameter, participantMapper);
    }

    private SqlParameterSource getParameters(long userId, long conferenceId) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("userId", userId);
        mapParameter.addValue("conferenceId", conferenceId);
        return mapParameter;
    }


}
