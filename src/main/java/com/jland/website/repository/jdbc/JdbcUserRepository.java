package com.jland.website.repository.jdbc;

import com.jland.website.model.User;
import com.jland.website.model.UserDetailsImpl;
import com.jland.website.repository.UserRepository;
import com.jland.website.repository.jdbc.util.OptionalResultSetExtractor;
import com.jland.website.repository.mapper.UserDetailsMapper;
import com.jland.website.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {

    private final UserMapper userMapper = new UserMapper();
    private final UserDetailsMapper userDetailsMapper = new UserDetailsMapper();

    private final ResultSetExtractor<Optional<User>> userExtractor
            = new OptionalResultSetExtractor<>(userMapper);
    private final ResultSetExtractor<Optional<UserDetailsImpl>> userDetailsExtractor
            = new OptionalResultSetExtractor<>(userDetailsMapper);

    private String findUserByUsernameSql;
    private String findUserByUsernameAndConferenceIdSql;



    private String findUserByIdAndConferenceIdSql;
    private String getAllByConferenceIdSql;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcUserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<UserDetailsImpl> findByUsername(String username) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("username", username);
        return namedParameterJdbcTemplate.query(findUserByUsernameSql, mapParameter, userDetailsExtractor);
    }

    @Override
    public Optional<User> findByUsernameAndConferenceId(String username, long conferenceId) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("username", username);
        mapParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(findUserByUsernameAndConferenceIdSql, mapParameter, userExtractor);
    }

    @Override
    public Optional<User> findByIdAndConferenceId(long id, long conferenceId) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("id", id);
        mapParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(findUserByIdAndConferenceIdSql, mapParameter, userExtractor);
    }

    @Override
    public List<User> getAll(long conferenceId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("conference_id", conferenceId);
        return namedParameterJdbcTemplate.query(getAllByConferenceIdSql, mapSqlParameter, userMapper);
    }

    @Autowired
    public void setFindUserByUsernameSql(String findUserByUsernameSql) {
        this.findUserByUsernameSql = findUserByUsernameSql;
    }

    @Autowired
    public void setFindUserByUsernameAndConferenceIdSql(String findUserByUsernameAndConferenceIdSql) {
        this.findUserByUsernameAndConferenceIdSql = findUserByUsernameAndConferenceIdSql;
    }

    @Autowired
    public void setGetAllByConferenceId(String getAllByConferenceIdSql) {
        this.getAllByConferenceIdSql = getAllByConferenceIdSql;
    }

    @Autowired
    public void setFindUserByIdAndConferenceIdSql(String findUserByIdAndConferenceIdSql) {
        this.findUserByIdAndConferenceIdSql = findUserByIdAndConferenceIdSql;
    }

    @Autowired
    public void setGetAllByConferenceIdSql(String getAllByConferenceIdSql) {
        this.getAllByConferenceIdSql = getAllByConferenceIdSql;
    }
}
