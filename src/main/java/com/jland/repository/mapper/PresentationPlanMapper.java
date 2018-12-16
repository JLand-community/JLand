package com.jland.repository.mapper;

import com.jland.model.PresentationPlan;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PresentationPlanMapper implements RowMapper<PresentationPlan> {

    @Override
    public PresentationPlan mapRow(ResultSet resultSet, int i) throws SQLException {
        PresentationPlan presentationPlan = new PresentationPlan();
        presentationPlan.setItem(resultSet.getString("point"));
        return presentationPlan;
    }
}
