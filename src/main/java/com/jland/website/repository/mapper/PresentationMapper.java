package com.jland.website.repository.mapper;

import com.jland.website.model.Presentation;
import com.jland.website.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PresentationMapper implements RowMapper<Presentation> {

    @Override
    public Presentation mapRow(ResultSet resultSet, int i) throws SQLException {
        Presentation presentation = new Presentation();
        presentation.setId(resultSet.getLong("presentation_id"));
        presentation.setName(resultSet.getString("presentation_name"));
        User user = getUser(resultSet);
        presentation.setUser(user);
        return presentation;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        return user;
    }

}
