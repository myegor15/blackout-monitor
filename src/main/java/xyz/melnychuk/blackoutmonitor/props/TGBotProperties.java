package xyz.melnychuk.blackoutmonitor.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "telegram.bot")
public record TGBotProperties(@JsonProperty("token") String token,
                              @JsonProperty("name") String name,
                              @JsonProperty("webhook-path") String webhookPath) {
}
