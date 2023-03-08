package xyz.melnychuk.blackoutmonitor.exception;

import xyz.melnychuk.blackoutmonitor.constants.ClientErrorCode;

public class AppClientException extends AppServiceException {

    private final ClientErrorCode errorCode;

    public AppClientException(ClientErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public AppClientException(ClientErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

}
