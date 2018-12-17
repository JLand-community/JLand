package com.jland.website.repository.mapper;

import com.jland.website.model.PresentationPlan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PresentationPlanMapper implements RowMapper<PresentationPlan> {

    @Override
    public PresentationPlan mapRow(ResultSet resultSet, int i) throws SQLException {
        PresentationPlan presentationPlan = new PresentationPlan();
        presentationPlan.setId(resultSet.getLong("id"));
        presentationPlan.setItem(resultSet.getString("point"));
        return presentationPlan;
    }
}
