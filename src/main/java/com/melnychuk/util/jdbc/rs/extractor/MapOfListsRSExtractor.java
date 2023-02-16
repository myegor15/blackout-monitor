package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSRowMapper;

import java.util.ArrayList;
import java.util.List;

public class MapOfListsRSExtractor<K, T> extends MapOfCollectionsExtractor<K, T, List<T>> {

    public MapOfListsRSExtractor(RSRowMapper<K> keyMapper, RSRowMapper<T> valueMapper) {
        super(keyMapper, valueMapper);
    }

    @Override
    protected List<T> initCollection() {
        return new ArrayList<>();
    }
}
