package com.jland.website.repository.mapper;

import com.jland.website.model.PresentationPlanItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PresentationPlanItemMapperTest {

    @Mock
    private ResultSet resultSet;

    @Test
    void mapRow() throws SQLException {
        // Given
        PresentationPlanItem presentationPlanItem = new PresentationPlanItem();
        presentationPlanItem.setId(1L);
        presentationPlanItem.setItemName("point");
        given(resultSet.getLong("id")).willReturn(presentationPlanItem.getId());
        given((resultSet.getString("point"))).willReturn(presentationPlanItem.getItemName());
        PresentationPlanMapper mapper = new PresentationPlanMapper();

        // When
        PresentationPlanItem result = mapper.mapRow(resultSet, 0);
        assertThat(result).isEqualTo(presentationPlanItem);


    }
}