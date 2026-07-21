package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringLearnApplication - Main entry point.
 * Exercise 4: JWT Authentication with Spring Security
 *
 * To test the authentication endpoint:
 *   curl -s -u user:pwd http://localhost:8090/authenticate
 *
 * Expected Response:
 *   {"token":"eyJhbGciOiJIUzI1NiJ9...."}
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringLearnApplication main() method");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END - SpringLearnApplication main() method");
        LOGGER.info("Authentication endpoint: http://localhost:8090/authenticate");
        LOGGER.info("Test with: curl -s -u user:pwd http://localhost:8090/authenticate");
    }
}
