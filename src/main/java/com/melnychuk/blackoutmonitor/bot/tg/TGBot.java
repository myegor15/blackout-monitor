package com.melnychuk.blackoutmonitor.bot.tg;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.generics.WebhookBot;

public interface TGBot extends WebhookBot {
    void sendMessage(Long chatId, String text);
    void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard);
}
