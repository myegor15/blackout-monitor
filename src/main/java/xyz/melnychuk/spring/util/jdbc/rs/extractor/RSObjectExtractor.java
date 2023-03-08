package xyz.melnychuk.spring.util.jdbc.rs.extractor;

import xyz.melnychuk.spring.util.jdbc.rs.RSMapper;
import xyz.melnychuk.spring.util.jdbc.rs.RSGetter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RSObjectExtractor<T> implements ResultSetExtractor<T> {

    private final RSMapper<T> rsMapper;

    public RSObjectExtractor(RSMapper<T> rsMapper) {
        Assert.notNull(rsMapper, "rowMapper cannot be null");
        this.rsMapper = rsMapper;
    }

    @Override
    public T extractData(ResultSet rs) throws SQLException, DataAccessException {
        return rs.next() ? rsMapper.mapRow(new RSGetter(rs)) : null;
    }

}
