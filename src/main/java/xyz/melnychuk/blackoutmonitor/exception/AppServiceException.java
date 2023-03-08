package xyz.melnychuk.blackoutmonitor.exception;

public class AppServiceException extends RuntimeException {
    public AppServiceException() {
        super();
    }

    public AppServiceException(String message) {
        super(message);
    }

    public AppServiceException(Throwable cause) {
        super(cause);
    }

    public AppServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
