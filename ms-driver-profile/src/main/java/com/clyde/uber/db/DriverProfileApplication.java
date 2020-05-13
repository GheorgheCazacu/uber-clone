package com.clyde.uber.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.clyde.uber.db")
@EnableJpaRepositories(basePackages = "com.clyde.uber.db")
@SpringBootApplication
@PropertySources(value = {
        @PropertySource(ignoreResourceNotFound = true,
                value = "classpath:application.properties")
})
public class DriverProfileApplication {
    public static void main(String[] args) {

        SpringApplication.run(DriverProfileApplication.class, args);
    }

}
