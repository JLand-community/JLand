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
        return presentation;
    }

}
