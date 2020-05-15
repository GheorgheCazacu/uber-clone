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
@PropertySource("classpath:application.properties")
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "payment", configuration = RibbonConfiguration.class)
public class PaymentApplication {
    public static void main(String[] args) {

        SpringApplication.run(PaymentApplication.class, args);
    }

}
