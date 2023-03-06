package com.melnychuk.util.jdbc.ps;

import com.melnychuk.util.jdbc.JDBCException;

public class PSException extends JDBCException {

    public PSException(Throwable cause) {
        super(cause);
    }

    public PSException(String message, Throwable cause) {
        super(message, cause);
    }
}
