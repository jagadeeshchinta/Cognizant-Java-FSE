package com.cognizant.springlearn.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Base64;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AuthControllerTest - Integration tests for JWT Authentication endpoint.
 * Exercise 4: Create Authentication Service that returns JWT
 *
 * Tests:
 * 1. GET /authenticate with valid credentials → 200 OK with JWT token
 * 2. GET /authenticate without credentials    → 401 Unauthorized
 * 3. GET /authenticate with wrong credentials → 401 Unauthorized
 * 4. GET /country without JWT                 → 401 Unauthorized
 */
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Builds a Basic Authorization header value.
     * Encodes "username:password" in Base64.
     */
    private String basicAuth(String username, String password) {
        String credentials = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    /**
     * Test 1: Valid credentials return 200 OK with a JWT token in the response body.
     * The response JSON should contain a "token" field with a non-null value.
     */
    @Test
    void testAuthenticate_ValidCredentials_Returns200WithToken() throws Exception {
        mockMvc.perform(get("/authenticate")
                        .header("Authorization", basicAuth("user", "pwd")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())          // "token" field exists
                .andExpect(jsonPath("$.token").value(notNullValue())); // token is not null
    }

    /**
     * Test 2: No Authorization header returns 401 Unauthorized.
     */
    @Test
    void testAuthenticate_NoCredentials_Returns401() throws Exception {
        mockMvc.perform(get("/authenticate"))
                .andExpect(status().isUnauthorized());
    }

    /**
     * Test 3: Wrong password returns 401 Unauthorized.
     */
    @Test
    void testAuthenticate_WrongPassword_Returns401() throws Exception {
        mockMvc.perform(get("/authenticate")
                        .header("Authorization", basicAuth("user", "wrongpassword")))
                .andExpect(status().isUnauthorized());
    }

    /**
     * Test 4: Accessing /country without any authentication returns 401 Unauthorized.
     * (This endpoint is secured and requires JWT Bearer token.)
     */
    @Test
    void testSecuredEndpoint_WithoutToken_Returns401() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isUnauthorized());
    }
}
