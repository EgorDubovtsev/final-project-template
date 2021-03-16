package com.epam.rd.izh.config;

import com.epam.rd.izh.mappers.AuthorizedUserMapper;
import com.epam.rd.izh.mappers.BookMapper;
import com.epam.rd.izh.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class WebConfig {

    @Bean
    public AuthorizedUserMapper authorizedUserMapper() {
        return new AuthorizedUserMapper();
    }

    @Bean
    public UserPriorityService userPriority() {
        return new SimpleUserPriorityService();
    }

    @Bean
    public BookMapper bookMapper() {
        return new BookMapper();
    }


    @Bean
    public FieldChecker fieldChecker() {
        return new FieldCheckerService();
    }

    @Bean
    public SearchService searchService() {
        return new SimpleSearchService();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
