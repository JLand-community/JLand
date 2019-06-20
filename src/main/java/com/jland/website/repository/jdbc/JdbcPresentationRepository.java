package com.jland.website.repository.jdbc;

import com.jland.website.model.PresentationPlanItem;
import com.jland.website.repository.PresentationRepository;
import com.jland.website.repository.mapper.PresentationPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPresentationRepository implements PresentationRepository {

    private final PresentationPlanMapper presentationPlanMapper = new PresentationPlanMapper();

    private String getPresentationPlanItemsSql;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JdbcPresentationRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<PresentationPlanItem> getPresentationPlan(Long presentationId) {
        MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
        mapSqlParameter.addValue("presentation_id", presentationId);
        return namedParameterJdbcTemplate.query(getPresentationPlanItemsSql, mapSqlParameter, presentationPlanMapper);
    }

    @Autowired
    public void setGetPresentationPlanItemsSql(String getPresentationPlanItemsSql) {
        this.getPresentationPlanItemsSql = getPresentationPlanItemsSql;
    }
}
