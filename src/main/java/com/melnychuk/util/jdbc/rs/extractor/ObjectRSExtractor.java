package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSGetter;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectRSExtractor<T> implements ResultSetExtractor<T> {

    private final RSRowMapper<T> rowMapper;

    public ObjectRSExtractor(RSRowMapper<T> rowMapper) {
        Assert.notNull(rowMapper, "rowMapper cannot be null");
        this.rowMapper = rowMapper;
    }

    @Override
    public T extractData(ResultSet rs) throws SQLException, DataAccessException {
        return rs.next() ? rowMapper.mapRow(new RSGetter(rs)) : null;
    }
}
