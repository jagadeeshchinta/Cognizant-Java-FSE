package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController - Hello World REST endpoint (carried forward from Exercise 3).
 * Exercise 4: Now secured by Spring Security — requires authentication.
 *
 * Note: In SecurityConfig, all endpoints except /authenticate require a valid JWT.
 * Access this endpoint with: Authorization: Bearer <token>
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START - sayHello()");
        String response = "Hello World!!";
        LOGGER.info("END - sayHello(). Returning: {}", response);
        return response;
    }
}
