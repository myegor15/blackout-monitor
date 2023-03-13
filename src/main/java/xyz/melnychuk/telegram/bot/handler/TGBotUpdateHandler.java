package xyz.melnychuk.telegram.bot.handler;

import xyz.melnychuk.telegram.bot.UserRequest;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

@FunctionalInterface
public interface TGBotUpdateHandler {
    BotApiMethod<?> handle(UserRequest request);
}
