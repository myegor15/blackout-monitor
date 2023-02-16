package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSGetter;
import com.melnychuk.util.jdbc.rs.RSRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapRSExtractor<K, V> implements ResultSetExtractor<Map<K, V>> {

    private final RSRowMapper<K> keyMapper;
    private final RSRowMapper<V> valueMapper;

    public MapRSExtractor(RSRowMapper<K> keyMapper, RSRowMapper<V> valueMapper) {
        Assert.notNull(keyMapper, "keyMapper cannot be null");
        Assert.notNull(valueMapper, "valueMapper cannot be null");
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
    }

    @Override
    public Map<K, V> extractData(ResultSet rs) throws SQLException {
        RSGetter rsGetter = new RSGetter(rs);
        Map<K, V> result = new HashMap<>();
        while (rs.next()) {
            K key = this.keyMapper.mapRow(rsGetter);
            V value = this.valueMapper.mapRow(rsGetter);
            result.put(key, value);
        }
        return result;
    }
}
