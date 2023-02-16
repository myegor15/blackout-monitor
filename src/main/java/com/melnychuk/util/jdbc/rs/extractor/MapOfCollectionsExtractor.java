package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSGetter;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class MapOfCollectionsExtractor<K, T, V extends Collection<T>> implements ResultSetExtractor<Map<K, V>> {

    private final RSRowMapper<K> keyMapper;
    private final RSRowMapper<T> valueMapper;

    public MapOfCollectionsExtractor(RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        Assert.notNull(keyMapper, "keyMapper cannot be null");
        Assert.notNull(valueMapper, "valueMapper cannot be null");
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
    }

    protected abstract V initCollection();

    @Override
    public Map<K, V> extractData(ResultSet rs) throws SQLException, DataAccessException {
        RSGetter rsGetter = new RSGetter(rs);
        Map<K, V> result = new HashMap<>();
        while (rs.next()) {
            K key = this.keyMapper.mapRow(rsGetter);
            T t = this.valueMapper.mapRow(rsGetter);
            result.computeIfAbsent(key, k -> initCollection())
                    .add(t);
        }
        return result;
    }
}
