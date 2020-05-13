package com.clyde.uber.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.clyde.uber.db")
@SpringBootApplication
public class DriverProfileApplication {
    public static void main(String[] args) {

        SpringApplication.run(DriverProfileApplication.class, args);
    }

}
