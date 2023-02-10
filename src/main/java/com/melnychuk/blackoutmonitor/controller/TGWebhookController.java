package com.melnychuk.blackoutmonitor.controller;

import com.melnychuk.blackoutmonitor.bot.tg.TGBot;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@AllArgsConstructor
public class TGWebhookController {

    private final TGBot bot;

    @PostMapping("/tg")
    public BotApiMethod<?> onWebhookUpdate(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}
