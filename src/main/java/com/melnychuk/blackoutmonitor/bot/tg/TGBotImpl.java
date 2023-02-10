package com.melnychuk.blackoutmonitor.bot.tg;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Slf4j
@Getter
@Builder
public class TGBotImpl extends TelegramWebhookBot implements TGBot {

    private final String botUsername;
    private final String botToken;
    private final String botPath;

    @Getter(AccessLevel.NONE)
    private final SetWebhook setWebhook;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null; //TODO: try catch
    }

    @Override
    public void sendMessage(Long chatId, String text) {
        sendMessage(chatId, text, null);
    }

    @Override
    public void sendMessage(Long chatId, String text, ReplyKeyboard replyKeyboard) {
        try {
            SendMessage sendMessage = SendMessage
                    .builder()
                    .text(text)
                    .chatId(chatId.toString())
                    .parseMode(ParseMode.HTML) //Other possible parse modes: MARKDOWNV2, MARKDOWN, which allows to make text bold, and all other things
                    .replyMarkup(replyKeyboard)
                    .build();
            this.execute(sendMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
