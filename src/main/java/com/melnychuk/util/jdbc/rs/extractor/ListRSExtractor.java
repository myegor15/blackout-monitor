package com.melnychuk.util.jdbc.rs.extractor;

import com.melnychuk.util.jdbc.rs.RSRowMapper;

import java.util.ArrayList;
import java.util.List;

public class ListRSExtractor<T> extends CollectionRSExtractor<T, List<T>> {

    public ListRSExtractor(RSRowMapper<T> rowMapper) {
        super(rowMapper);
    }

    @Override
    protected List<T> initCollection() {
        return new ArrayList<>();
    }
}
