package com.clyde.uber.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.clyde.uber.db")
@ComponentScan("com.clyde.uber.db")
@Configuration
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "trip", configuration = RibbonConfiguration.class)
public class TripApplication {
    public static void main(String[] args) {

        SpringApplication.run(TripApplication.class, args);
    }

}
