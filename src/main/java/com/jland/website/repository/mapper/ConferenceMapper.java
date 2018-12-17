package com.jland.website.repository.mapper;

import com.jland.website.model.Conference;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConferenceMapper implements RowMapper<Conference> {

    @Override
    public Conference mapRow(ResultSet resultSet, int i) throws SQLException {
        Conference conference = new Conference();
        conference.setId(resultSet.getLong("id"));
        conference.setDescription(resultSet.getString("description"));
        LocalDate date = resultSet.getDate("date").toLocalDate();
        conference.setDate(date);
        conference.setAddress(resultSet.getString("address"));
        return conference;
    }
}
