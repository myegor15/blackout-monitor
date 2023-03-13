package xyz.melnychuk.blackoutmonitor.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.melnychuk.spring.jdbc.JdbcTemplateWrapper;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class DatabaseConfig {

    private final DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource, false);
    }

    @Bean
    public JdbcTemplateWrapper jdbcTemplateWrapper() {
        return new JdbcTemplateWrapper(jdbcTemplate());
    }
}
