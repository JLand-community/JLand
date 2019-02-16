package com.jland.website.repository.jdbc.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class OptionalResultSetExtractor<T> implements ResultSetExtractor<Optional<T>> {

    private final RowMapper<T> mapper;

    public OptionalResultSetExtractor(RowMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<T> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return resultSet.next() ? Optional.of(mapper.mapRow(resultSet, 1)) : Optional.empty();
    }
}
