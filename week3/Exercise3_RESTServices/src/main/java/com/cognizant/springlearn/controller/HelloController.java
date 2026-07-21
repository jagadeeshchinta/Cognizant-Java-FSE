package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController - REST Controller for the Hello World endpoint.
 * Exercise 3: Hello World RESTful Web Service
 *
 * @RestController is a convenience annotation that combines:
 *   - @Controller   : Marks this class as a Spring MVC controller
 *   - @ResponseBody : Serializes the return value directly to the HTTP response body
 *
 * The Dispatcher Servlet receives every HTTP request, looks up the matching
 * controller method via @GetMapping, and routes the request to it.
 *
 * Test URL: http://localhost:8083/hello
 *
 * HTTP Response:
 *   Status : 200 OK
 *   Body   : Hello World!!
 *   Content-Type: text/plain;charset=UTF-8
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * sayHello() - Handles GET requests to /hello.
     *
     * Method: GET
     * URL   : /hello
     *
     * @return "Hello World!!" as plain text response
     */
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START - sayHello()");

        String response = "Hello World!!";

        LOGGER.info("END - sayHello(). Returning: {}", response);
        return response;
    }
}
