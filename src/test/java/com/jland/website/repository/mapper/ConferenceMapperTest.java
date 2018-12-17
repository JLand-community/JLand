package com.jland.website.repository.mapper;

import com.jland.website.model.Conference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

class ConferenceMapperTest {

    private ResultSet resultSet = Mockito.mock(ResultSet.class);

    @Test
    void mapRow() throws SQLException {
        when(resultSet.getLong(ArgumentMatchers.any())).thenReturn(1L);
        when(resultSet.getString(ArgumentMatchers.any())).thenReturn("Conference").thenReturn("Fabra");
        when(resultSet.getDate(ArgumentMatchers.any())).thenReturn(Date.valueOf(LocalDate.of(2019, 1, 12)));

        ConferenceMapper mapper = new ConferenceMapper();
        Conference conferenceActual = mapper.mapRow(resultSet, 0);
        Assertions.assertEquals(1L, conferenceActual.getId());
        Assertions.assertEquals("Conference", conferenceActual.getDescription());
        Assertions.assertEquals(LocalDate.of(2019, 1, 12), conferenceActual.getDate());
        Assertions.assertEquals("Fabra", conferenceActual.getAddress());
    }
}