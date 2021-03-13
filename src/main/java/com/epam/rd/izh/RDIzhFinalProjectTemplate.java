package com.epam.rd.izh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class RDIzhFinalProjectTemplate {
    public static void main(String[] args) {
        SpringApplication.run(RDIzhFinalProjectTemplate.class, args);
    }
}
