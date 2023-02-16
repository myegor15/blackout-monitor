package com.melnychuk.blackoutmonitor.util.jdbc;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.function.Consumer;

public interface PSSetterConsumer extends Consumer<PSSetter>, PreparedStatementSetter {

    @Override
    default void setValues(PreparedStatement ps) throws SQLException {
        accept(new PSSetter(ps));
    }
}
