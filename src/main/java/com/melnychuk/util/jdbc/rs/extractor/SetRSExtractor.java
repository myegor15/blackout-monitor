package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSRowMapper;

import java.util.HashSet;
import java.util.Set;

public class SetRSExtractor<T> extends CollectionRSExtractor<T, Set<T>> {

    public SetRSExtractor(RSRowMapper<T> rowMapper) {
        super(rowMapper);
    }

    @Override
    protected Set<T> initCollection() {
        return new HashSet<>();
    }
}
