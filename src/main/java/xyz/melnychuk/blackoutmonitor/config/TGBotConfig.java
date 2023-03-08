package xyz.melnychuk.blackoutmonitor.config;

import xyz.melnychuk.blackoutmonitor.bot.tg.TGBot;
import xyz.melnychuk.blackoutmonitor.bot.tg.TGBotImpl;
import xyz.melnychuk.blackoutmonitor.props.TGBotProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
public class TGBotConfig {

    private final TGBotProperties properties;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder()
                .url(properties.getWebhookPath())
                .build();
    }

    @Bean
    public TGBot tgBot(SetWebhook setWebhook) {
        return TGBotImpl.builder()
                .botUsername(properties.getBotName())
                .botToken(properties.getBotToken())
                .botPath(properties.getWebhookPath())
                .setWebhook(setWebhook)
                .build();
    }
}
