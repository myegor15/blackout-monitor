package xyz.melnychuk.spring.jdbc.rs.extractor;

import xyz.melnychuk.spring.jdbc.rs.RSGetter;
import xyz.melnychuk.spring.jdbc.rs.RSMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.function.Supplier;

public class RSCollectionExtractor<T, C extends Collection<T>> implements ResultSetExtractor<C> {

    private final RSMapper<T> rsMapper;
    private final Supplier<C> collectionSupplier;

    public RSCollectionExtractor(RSMapper<T> rsMapper, Supplier<C> collectionSupplier) {
        Assert.notNull(rsMapper, "rsMapper cannot be null");
        Assert.notNull(collectionSupplier, "collectionSupplier cannot be null");
        this.rsMapper = rsMapper;
        this.collectionSupplier = collectionSupplier;
    }

    @Override
    public C extractData(ResultSet rs) throws SQLException, DataAccessException {
        RSGetter rsGetter = new RSGetter(rs);
        C result = this.collectionSupplier.get();
        while (rs.next()) {
            T item = this.rsMapper.mapRow(rsGetter);
            result.add(item);
        }
        return result;
    }

}
