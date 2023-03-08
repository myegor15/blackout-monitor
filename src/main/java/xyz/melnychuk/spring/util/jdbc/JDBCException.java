package xyz.melnychuk.spring.util.jdbc;

public class JDBCException extends RuntimeException {

    public JDBCException(String message) {
        super(message);
    }

    public JDBCException(Throwable cause) {
        super(cause);
    }

    public JDBCException(String message, Throwable cause) {
        super(message, cause);
    }
}
