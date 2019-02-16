package com.jland.website.repository.mapper;

import com.jland.website.model.PresentationPlanItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PresentationPlanMapper implements RowMapper<PresentationPlanItem> {

    @Override
    public PresentationPlanItem mapRow(ResultSet resultSet, int i) throws SQLException {
        PresentationPlanItem presentationPlanItem = new PresentationPlanItem();
        presentationPlanItem.setId(resultSet.getLong("id"));
        presentationPlanItem.setItem(resultSet.getString("point"));
        return presentationPlanItem;
    }
}
