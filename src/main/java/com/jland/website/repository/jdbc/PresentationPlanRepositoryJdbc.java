package com.jland.website.repository.jdbc;

import com.jland.website.model.PresentationPlan;
import com.jland.website.repository.PresentationPlanRepository;
import com.jland.website.repository.mapper.PresentationPlanMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PresentationPlanRepositoryJdbc implements PresentationPlanRepository {

    private static final PresentationPlanMapper PRESENTATION_PLAN_MAPPER = new PresentationPlanMapper();
    private static final String GET_PRESENTATION_PLAN_SQL = "select point from jland_site.presentation_plan plan where presentation_id = :presentation_id order by item_order asc;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PresentationPlanRepositoryJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<PresentationPlan> getAllByPresentationId(Long presentationId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("presentation_id", presentationId);
        return namedParameterJdbcTemplate.query(GET_PRESENTATION_PLAN_SQL, mapSqlParameter, PRESENTATION_PLAN_MAPPER);
    }
}
