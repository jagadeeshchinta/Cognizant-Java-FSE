package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringLearnApplication - Main entry point.
 * Exercise 3: RESTful Web Services
 *
 * Once started, the following REST endpoints are available:
 *   GET http://localhost:8083/hello          → "Hello World!!"
 *   GET http://localhost:8083/country        → India country details as JSON
 *   GET http://localhost:8083/countries/{code} → Country by ISO code (case-insensitive)
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringLearnApplication main() method");

        SpringApplication.run(SpringLearnApplication.class, args);

        LOGGER.info("END - SpringLearnApplication main() method");
        LOGGER.info("REST API available at: http://localhost:8083");
    }
}
