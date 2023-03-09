package xyz.melnychuk.spring.jdbc.ps;

import xyz.melnychuk.spring.jdbc.JDBCException;

public class PSException extends JDBCException {

    public PSException(String message) {
        super(message);
    }

    public PSException(Throwable cause) {
        super(cause);
    }

    public PSException(String message, Throwable cause) {
        super(message, cause);
    }
}
