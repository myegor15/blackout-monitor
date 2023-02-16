package com.melnychuk.blackoutmonitor.util.jdbc;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapRSExtractor<K, V> implements ResultSetExtractor<Map<K, V>> {

    private final RowMapper<K> keyMapper;
    private final RowMapper<V> valueMapper;

    public MapRSExtractor(RowMapper<K> keyMapper, RowMapper<V> valueMapper) {
        Assert.notNull(keyMapper, "KeyMapper must not be null");
        Assert.notNull(valueMapper, "ValueMapper must not be null");
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
    }

    @Override
    public Map<K, V> extractData(ResultSet rs) throws SQLException {
        Map<K, V> result = new HashMap<>();
        int rowNum = 0;
        while (rs.next()) {
            rowNum++;
            K key = this.keyMapper.mapRow(rs, rowNum);
            V value = this.valueMapper.mapRow(rs, rowNum);
            result.put(key, value);
        }
        return result;
    }
}
