package xyz.melnychuk.blackoutmonitor.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import xyz.melnychuk.telegram.bot.TGBot;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@ConditionalOnBean(TGBot.class)
public class TGWebhookController {

    private final TGBot bot;

    @PostMapping("/tg")
    public BotApiMethod<?> onWebhookUpdate(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}
