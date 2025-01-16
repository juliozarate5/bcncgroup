package com.bcncgroup.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (
        scanBasePackages= {
                "com.bcncgroup.infrastructure",
                "com.bcncgroup.domain",
                "com.bcncgroup.application"
        })
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages= {"com.bcncgroup.infrastructure.persistence.jpa.repository"})
public class EcommercePriceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EcommercePriceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EcommercePriceApplication.class, args);
    }

}
