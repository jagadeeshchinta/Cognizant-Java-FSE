package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * AuthController - Authentication Controller that generates JWT tokens.
 * Exercise 4: Create Authentication Service that returns JWT
 *
 * Endpoint: GET /authenticate
 * Auth    : HTTP Basic (credentials sent via Authorization header)
 *
 * How HTTP Basic Authentication works:
 * 1. Client combines username and password: "user:pwd"
 * 2. Base64 encodes the string: "dXNlcjpwd2Q="
 * 3. Sends header: Authorization: Basic dXNlcjpwd2Q=
 * 4. Server decodes and authenticates
 *
 * curl equivalent:
 *   curl -s -u user:pwd http://localhost:8090/authenticate
 *
 * The -u flag in curl automatically creates the Basic Authorization header.
 *
 * Sample Response:
 * {
 *   "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTcwMzc5..."
 * }
 */
@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * authenticate() - Reads Basic Auth credentials and generates a JWT token.
     *
     * Step-by-Step Process:
     * 1. Read the "Authorization" header from the HTTP request
     *    Value example: "Basic dXNlcjpwd2Q="
     * 2. Remove the "Basic " prefix to get the Base64-encoded credentials
     * 3. Base64-decode to get "user:pwd"
     * 4. Split by ":" to extract username and password separately
     * 5. Generate a JWT token for the extracted username using JwtUtil
     * 6. Return the token as JSON: {"token": "eyJ..."}
     *
     * @param authHeader the Authorization header (e.g., "Basic dXNlcjpwd2Q=")
     * @return 200 OK with JSON body containing the JWT token
     */
    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START - authenticate()");
        LOGGER.debug("Authorization header received: {}", authHeader);

        // Step 1: Remove "Basic " prefix (length = 6)
        // authHeader = "Basic dXNlcjpwd2Q="
        // encoded    = "dXNlcjpwd2Q="
        String encoded = authHeader.substring(6);
        LOGGER.debug("Base64 encoded credentials: {}", encoded);

        // Step 2: Base64 decode
        // decoded = "user:pwd"
        String decoded = new String(Base64.getDecoder().decode(encoded));
        LOGGER.debug("Decoded credentials: {}", decoded.replaceAll(":.*", ":****"));

        // Step 3: Split by ":" to get username and password
        String[] parts    = decoded.split(":", 2);
        String   username = parts[0];
        // String password = parts[1]; // available for further validation if needed

        LOGGER.debug("Extracted username: {}", username);

        // Step 4: Generate JWT token for the authenticated user
        String token = jwtUtil.generateToken(username);

        // Step 5: Return token as JSON response body
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("END - authenticate(). JWT token generated for user: {}", username);
        return ResponseEntity.ok(response);
    }
}
