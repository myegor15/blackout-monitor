package com.melnychuk.util.jdbc.rs;

@FunctionalInterface
public interface RSRowMapper<T> {
    T mapRow(RSGetter rsGetter);
}
