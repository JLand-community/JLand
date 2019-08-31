package com.jland.website.repository.mapper;


import com.jland.website.model.UserDetailsImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsMapper implements RowMapper<UserDetailsImpl> {

    @Override
    public UserDetailsImpl mapRow(ResultSet resultSet, int i) throws SQLException {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setId(resultSet.getLong("id"));
        userDetails.setUsername(resultSet.getString("username"));
        userDetails.setPassword(resultSet.getString("password"));
        userDetails.setRole(resultSet.getString("user_role"));
        return userDetails;
    }

}