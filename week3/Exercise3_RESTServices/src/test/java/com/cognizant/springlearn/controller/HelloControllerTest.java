package com.cognizant.springlearn.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * HelloControllerTest - MockMVC tests for the Hello World REST endpoint.
 * Exercise 3: End-to-End Testing using MockMVC
 *
 * @SpringBootTest   : Loads the full Spring ApplicationContext
 * @AutoConfigureMockMvc : Configures MockMvc to simulate HTTP requests
 *                         without starting a real server
 *
 * MockMVC lets us test the HTTP layer (controller, routing, serialization)
 * without running an actual Tomcat server — fast and reliable.
 */
@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test: GET /hello returns HTTP 200 OK
     *
     * Verifies that the sayHello() endpoint:
     * - Returns HTTP status 200 (OK)
     * - Response body contains "Hello World!!"
     */
    @Test
    void testSayHello_Returns200AndHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))               // Simulate GET /hello
                .andExpect(status().isOk())          // Assert: HTTP 200 OK
                .andExpect(content().string("Hello World!!"));  // Assert: response body
    }
}
