package xyz.melnychuk.spring.jdbc.ps;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PSSetterExecutor extends PreparedStatementSetter {

    void execute(PSSetter psSetter);

    @Override
    default void setValues(PreparedStatement ps) throws SQLException {
        execute(new PSSetter(ps));
    }
}
