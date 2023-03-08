package xyz.melnychuk.spring.util.jdbc.rs.extractor;

import xyz.melnychuk.spring.util.jdbc.rs.RSMapper;
import xyz.melnychuk.spring.util.jdbc.rs.RSGetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Supplier;

public class RSMapExtractor<K, V> implements ResultSetExtractor<Map<K, V>> {

    private final RSMapper<K> keyMapper;
    private final RSMapper<V> valueMapper;
    private final Supplier<Map<K, V>> mapSupplier;

    public RSMapExtractor(RSMapper<K> keyMapper, RSMapper<V> valueMapper, Supplier<Map<K, V>> mapSupplier) {
        Assert.notNull(keyMapper, "keyMapper cannot be null");
        Assert.notNull(valueMapper, "valueMapper cannot be null");
        Assert.notNull(mapSupplier, "mapSupplier cannot be null");
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
        this.mapSupplier = mapSupplier;
    }

    @Override
    public Map<K, V> extractData(ResultSet rs) throws SQLException {
        RSGetter rsGetter = new RSGetter(rs);
        Map<K, V> result = this.mapSupplier.get();
        while (rs.next()) {
            K key = this.keyMapper.mapRow(rsGetter);
            V value = this.valueMapper.mapRow(rsGetter);
            result.put(key, value);
        }
        return result;
    }
}
