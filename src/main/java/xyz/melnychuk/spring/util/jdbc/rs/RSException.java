package xyz.melnychuk.spring.util.jdbc.rs;

import xyz.melnychuk.spring.util.jdbc.JDBCException;

public class RSException extends JDBCException {

    public RSException(String message) {
        super(message);
    }

    public RSException(Throwable cause) {
        super(cause);
    }

    public RSException(String message, Throwable cause) {
        super(message, cause);
    }
}
