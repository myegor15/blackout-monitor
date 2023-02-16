package com.melnychuk.util.jdbc.ps;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Consumer;

@FunctionalInterface
public interface PSSetterConsumer extends Consumer<PSSetter>, PreparedStatementSetter {

    @Override
    default void setValues(PreparedStatement ps) throws SQLException {
        accept(new PSSetter(ps));
    }
}
