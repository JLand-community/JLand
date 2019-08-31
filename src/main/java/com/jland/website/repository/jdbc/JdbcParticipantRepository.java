package com.jland.website.repository.jdbc;

import com.jland.website.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcParticipantRepository implements ParticipantRepository {

    private String addParticipantSql;
    private String removeParticipantSql;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcParticipantRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void participate(long userId, long conferenceId) {
        namedParameterJdbcTemplate.update(addParticipantSql, getParameters(userId, conferenceId));
    }

    @Override
    public void notParticipate(long userId, long conferenceId) {
        namedParameterJdbcTemplate.update(removeParticipantSql, getParameters(userId, conferenceId));
    }

    private SqlParameterSource getParameters(long userId, long conferenceId) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("userId", userId);
        mapParameter.addValue("conferenceId", conferenceId);
        return mapParameter;
    }

    @Autowired
    public void setAddParticipantSql(String addParticipantSql) {
        this.addParticipantSql = addParticipantSql;
    }

    @Autowired
    public void setRemoveParticipantSql(String removeParticipantSql) {
        this.removeParticipantSql = removeParticipantSql;
    }
}
