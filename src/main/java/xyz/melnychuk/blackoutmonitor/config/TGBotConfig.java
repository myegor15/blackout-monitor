package xyz.melnychuk.blackoutmonitor.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import xyz.melnychuk.blackoutmonitor.props.TGBotProperties;
import xyz.melnychuk.telegram.bot.TGBot;
import xyz.melnychuk.telegram.bot.TGBotImpl;
import xyz.melnychuk.telegram.bot.handler.command.TGBotCommand;
import xyz.melnychuk.telegram.bot.handler.command.TGBotCommandDispatcher;

import java.util.List;

@Configuration
@AllArgsConstructor(onConstructor_ = {@Autowired})
@ConditionalOnProperty(value = "telegram.bot.enable", havingValue = "true")
public class TGBotConfig {

    private final TGBotProperties botProperties;
    private final List<TGBotCommand> commands;

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder()
                .url(botProperties.webhookPath())
                .build();
    }

    @Bean
    public TGBotCommandDispatcher tgBotCommandDispatcher() {
        return new TGBotCommandDispatcher(commands);
    }

    @Bean
    public TGBot tgBot() {
        return TGBotImpl.builder()
                .botToken(botProperties.token())
                .botUsername(botProperties.name())
                .botPath(botProperties.webhookPath())
                .setWebhook(setWebhook())
                .commandDispatcher(tgBotCommandDispatcher())
                .build();
    }
}
