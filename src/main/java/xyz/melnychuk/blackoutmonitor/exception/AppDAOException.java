package xyz.melnychuk.blackoutmonitor.exception;

public class AppDAOException extends RuntimeException {
    public AppDAOException() {
    }

    public AppDAOException(String message) {
        super(message);
    }

    public AppDAOException(Throwable cause) {
        super(cause);
    }

    public AppDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
