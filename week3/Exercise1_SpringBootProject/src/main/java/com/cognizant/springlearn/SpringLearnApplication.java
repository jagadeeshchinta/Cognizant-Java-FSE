package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringLearnApplication - Main entry point for the Spring Boot application.
 * Exercise 1: Create a Spring Web Project using Maven
 *
 * @SpringBootApplication combines:
 *   - @Configuration      : Declares this as a Spring configuration class
 *   - @EnableAutoConfiguration : Enables Spring Boot's auto-configuration mechanism
 *   - @ComponentScan      : Scans com.cognizant.springlearn package for Spring beans
 *
 * SpringApplication.run() bootstraps the application:
 *   - Starts the embedded Tomcat server on the configured port
 *   - Loads the ApplicationContext
 *   - Registers all beans, controllers, and services
 */
@SpringBootApplication
public class SpringLearnApplication {

    // Logger instance using SLF4J - the standard logging facade for Spring Boot
    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringLearnApplication main() method");

        // SpringApplication.run() starts the embedded Tomcat and loads Spring context
        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("END - SpringLearnApplication main() method");
        LOGGER.info("Application started successfully on port 8083");
    }
}
