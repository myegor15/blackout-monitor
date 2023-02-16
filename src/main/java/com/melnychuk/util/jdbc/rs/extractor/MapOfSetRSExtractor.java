package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSRowMapper;

import java.util.HashSet;
import java.util.Set;

public class MapOfSetRSExtractor<K, T> extends MapOfCollectionsExtractor<K, T, Set<T>> {

    public MapOfSetRSExtractor(RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        super(keyMapper, valueMapper);
    }

    @Override
    protected Set<T> initCollection() {
        return new HashSet<>();
    }
}
