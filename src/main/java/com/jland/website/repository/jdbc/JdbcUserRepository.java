package com.jland.website.repository.jdbc;

import com.jland.website.model.User;
import com.jland.website.repository.UserRepository;
import com.jland.website.repository.mapper.UserMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {
    private final UserMapper userMapper = new UserMapper();
    private static final String FIND_USER_SQL = "SELECT jland_site.user.id user_id, first_name, last_name, username, password, user_role\n" +
            "FROM jland_site.user\n" +
            "WHERE username = :username;";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcUserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("username", username);
        return namedParameterJdbcTemplate.queryForObject(FIND_USER_SQL, mapParameter, userMapper);
    }



}
