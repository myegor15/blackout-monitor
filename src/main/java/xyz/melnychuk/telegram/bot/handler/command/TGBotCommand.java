package xyz.melnychuk.telegram.bot.handler.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import xyz.melnychuk.telegram.bot.UserRequest;
import xyz.melnychuk.telegram.bot.handler.TGBotUpdateHandler;

public abstract class TGBotCommand implements TGBotUpdateHandler {

    public abstract boolean isApplicable(UserRequest request);

    public abstract boolean isGlobal();

    public boolean isCommand(Update update, String command) {
        return update.hasMessage() && update.getMessage().isCommand()
                && update.getMessage().getText().equals(command);
    }

    public boolean isTextMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }

    public boolean isTextMessage(Update update, String text) {
        return update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals(text);
    }
}
