package com.jland.website.repository.mapper;

import com.jland.website.model.PresentationPlan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PresentationPlanMapperTest {

    @Mock
    private ResultSet resultSet;

    @Test
    public void mapRow() throws SQLException {
        // Given
        PresentationPlan presentationPlan = new PresentationPlan();
        presentationPlan.setId(1L);
        presentationPlan.setItem("point");
        given(resultSet.getLong("id")).willReturn(presentationPlan.getId());
        given((resultSet.getString("point"))).willReturn(presentationPlan.getItem());
        PresentationPlanMapper mapper = new PresentationPlanMapper();

        // When
        PresentationPlan result = mapper.mapRow(resultSet, 0);
        assertThat(result).isEqualTo(presentationPlan);


    }
}