package com.epam.rd.izh.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ResourceBundle;

@Configuration
public class JdbcConfiguration {

    @Bean
    public DataSource dataSource() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(resourceBundle.getString("spring.datasource.driverClassName"));
        dataSourceBuilder.url(resourceBundle.getString("spring.datasource.url"));
        dataSourceBuilder.username(resourceBundle.getString("spring.datasource.username"));
        dataSourceBuilder.password(resourceBundle.getString("spring.datasource.password"));
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
