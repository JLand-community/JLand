package com.jland.repository.impl;

import com.jland.model.PresentationPlan;
import com.jland.repository.PresentationPlanRepository;
import com.jland.repository.mapper.PresentationPlanMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class PresentationPlanRepositoryImpl implements PresentationPlanRepository {

    private static final PresentationPlanMapper presentationPlanMapper = new PresentationPlanMapper();
    private static final String GET_PRESENTATION_PLAN_SQL = "select point " +
            "from presentation_plan " +
            "where presentation_id = :presentation_id order by 'order' asc;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PresentationPlanRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<PresentationPlan> getPresentationPlanByPresentationId(Long presentationId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("presentation_id", presentationId);
        return namedParameterJdbcTemplate.query(GET_PRESENTATION_PLAN_SQL, mapSqlParameter, presentationPlanMapper);
    }
}
