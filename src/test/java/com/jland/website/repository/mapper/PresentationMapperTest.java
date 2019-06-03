package com.jland.website.repository.mapper;

import com.jland.website.model.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

class PresentationMapperTest {

    private ResultSet resultSet = Mockito.mock(ResultSet.class);

    @Test
    void mapRow() throws SQLException {
        when(resultSet.getLong("presentation_id")).thenReturn(1L);
        when(resultSet.getString("presentation_name")).thenReturn("presentation");
        when(resultSet.getString("first_name")).thenReturn("first");
        when(resultSet.getString("last_name")).thenReturn("last");

        PresentationMapper mapper = new PresentationMapper();
        Presentation presentation = mapper.mapRow(resultSet, 0);
        Assertions.assertEquals(1L, presentation.getId());
        Assertions.assertEquals("presentation", presentation.getName());
}
}