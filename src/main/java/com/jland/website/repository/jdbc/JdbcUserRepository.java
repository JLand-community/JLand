package com.jland.website.repository.jdbc;

import com.jland.website.model.User;
import com.jland.website.repository.UserRepository;
import com.jland.website.repository.jdbc.util.OptionalResultSetExtractor;
import com.jland.website.repository.mapper.UserMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {
    private final UserMapper userMapper = new UserMapper();
    private final ResultSetExtractor<Optional<User>> extractor = new OptionalResultSetExtractor<>(userMapper);
    private static final String FIND_USER_SQL = "SELECT jland_site.user.id user_id, first_name, last_name, photo, username, password, user_role\n" +
            "FROM jland_site.user\n" +
            "WHERE username = :username;";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcUserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        MapSqlParameterSource mapParameter = new MapSqlParameterSource();
        mapParameter.addValue("username", username);
        return namedParameterJdbcTemplate.query(FIND_USER_SQL, mapParameter, extractor);
    }



}
