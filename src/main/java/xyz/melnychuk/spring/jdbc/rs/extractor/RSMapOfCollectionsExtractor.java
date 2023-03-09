package xyz.melnychuk.spring.jdbc.rs.extractor;

import xyz.melnychuk.spring.jdbc.rs.RSMapper;
import xyz.melnychuk.spring.jdbc.rs.RSGetter;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class RSMapOfCollectionsExtractor<K, T, V extends Collection<T>> implements ResultSetExtractor<Map<K, V>> {

    private final RSMapper<K> keyMapper;
    private final RSMapper<T> valueMapper;
    private final Supplier<Map<K, V>> mapSupplier;
    private final Supplier<V> collectionSupplier;

    public RSMapOfCollectionsExtractor(RSMapper<K> keyMapper, RSMapper<T> valueMapper, Supplier<Map<K, V>> mapSupplier, Supplier<V> collectionSupplier) {
        Assert.notNull(keyMapper, "keyMapper cannot be null");
        Assert.notNull(valueMapper, "valueMapper cannot be null");
        Assert.notNull(mapSupplier, "mapSupplier cannot be null");
        Assert.notNull(collectionSupplier, "collectionSupplier cannot be null");
        this.keyMapper = keyMapper;
        this.valueMapper = valueMapper;
        this.mapSupplier = mapSupplier;
        this.collectionSupplier = collectionSupplier;
    }

    @Override
    public Map<K, V> extractData(ResultSet rs) throws SQLException, DataAccessException {
        RSGetter rsGetter = new RSGetter(rs);
        Map<K, V> result = this.mapSupplier.get();
        while (rs.next()) {
            K key = this.keyMapper.mapRow(rsGetter);
            T t = this.valueMapper.mapRow(rsGetter);
            result.computeIfAbsent(key, k -> this.collectionSupplier.get())
                    .add(t);
        }
        return result;
    }
}
