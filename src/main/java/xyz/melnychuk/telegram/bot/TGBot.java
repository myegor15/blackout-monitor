package xyz.melnychuk.telegram.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import xyz.melnychuk.telegram.bot.exception.TGBotException;

public interface TGBot extends WebhookBot {
    void sendMessage(Long chatId, String text) throws TGBotException;
    void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard) throws TGBotException;
}
