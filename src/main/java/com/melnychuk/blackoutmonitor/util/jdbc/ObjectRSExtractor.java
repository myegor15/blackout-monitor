package com.melnychuk.blackoutmonitor.util.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRSExtractor<T> implements ResultSetExtractor<T> {

    private final RowMapper<T> rowMapper;

    public ObjectRSExtractor(RowMapper<T> rowMapper) {
        Assert.notNull(rowMapper, "RowMapper must not be null");
        this.rowMapper = rowMapper;
    }

    @Override
    public T extractData(ResultSet rs) throws SQLException, DataAccessException {
        return rs.next() ? rowMapper.mapRow(rs, 1) : null;
    }
}
