package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSGetter;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public abstract class CollectionRSExtractor<T, C extends Collection<T>> implements ResultSetExtractor<C> {

    private final RSRowMapper<T> rowMapper;

    public CollectionRSExtractor(RSRowMapper<T> rowMapper) {
        Assert.notNull(rowMapper, "rowMapper cannot be null");
        this.rowMapper = rowMapper;
    }

    protected abstract C initCollection();

    @Override
    public C extractData(ResultSet rs) throws SQLException, DataAccessException {
        RSGetter rsGetter = new RSGetter(rs);
        C result = initCollection();
        while (rs.next()) {
            T item = this.rowMapper.mapRow(rsGetter);
            result.add(item);
        }
        return result;
    }

}
