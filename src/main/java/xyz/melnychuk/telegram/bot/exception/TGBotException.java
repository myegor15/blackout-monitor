package xyz.melnychuk.telegram.bot.exception;

public class TGBotException extends RuntimeException {

    public TGBotException(String message) {
        super(message);
    }

    public TGBotException(Throwable cause) {
        super(cause);
    }

    public TGBotException(String message, Throwable cause) {
        super(message, cause);
    }
}
