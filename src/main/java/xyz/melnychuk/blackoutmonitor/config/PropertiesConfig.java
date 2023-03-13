package xyz.melnychuk.blackoutmonitor.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan("xyz.melnychuk.blackoutmonitor.props")
public class PropertiesConfig {
}
