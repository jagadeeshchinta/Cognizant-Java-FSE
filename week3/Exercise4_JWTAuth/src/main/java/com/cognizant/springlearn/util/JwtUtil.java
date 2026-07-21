package com.cognizant.springlearn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * JwtUtil - Utility class for JWT token generation and validation.
 * Exercise 4: Create Authentication Service that returns JWT
 *
 * JWT Structure (three Base64-encoded parts separated by dots):
 * ┌──────────────────────────────────────────────────────────────┐
 * │  HEADER.PAYLOAD.SIGNATURE                                    │
 * │                                                              │
 * │  Header   : {"alg":"HS256","typ":"JWT"}                      │
 * │  Payload  : {"sub":"user","iat":1570379474,"exp":1570380674} │
 * │  Signature: HMACSHA256(base64(header)+"."+base64(payload),   │
 * │             secret)                                          │
 * └──────────────────────────────────────────────────────────────┘
 *
 * JWT Process Flow:
 * 1. Client sends credentials (user:pwd) in Authorization Basic header
 * 2. Server authenticates and generates JWT with user info + expiry
 * 3. Server returns JWT in response body as {"token":"..."}
 * 4. Client includes JWT in subsequent requests: Authorization: Bearer <token>
 * 5. Server validates JWT signature and extracts user info
 */
@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    /**
     * Generates a signed JWT token for the given username.
     *
     * Token Claims:
     * - sub (Subject)        : Username
     * - iat (Issued At)      : Current timestamp
     * - exp (Expiration)     : Current time + expiration (from properties)
     *
     * Algorithm: HS256 (HMAC with SHA-256) - symmetric key signing
     *
     * @param username the authenticated username to embed in the token
     * @return signed JWT token string
     */
    public String generateToken(String username) {
        LOGGER.info("START - generateToken() for username: {}", username);

        // Create a secure signing key from the secret string
        SecretKey signingKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );

        Date issuedAt   = new Date();
        Date expiryDate = new Date(issuedAt.getTime() + expiration);

        String token = Jwts.builder()
                .setSubject(username)           // "sub" claim: the user
                .setIssuedAt(issuedAt)          // "iat" claim: issued timestamp
                .setExpiration(expiryDate)      // "exp" claim: expiry timestamp
                .signWith(signingKey, SignatureAlgorithm.HS256)  // Sign with HS256
                .compact();                     // Build and serialize the JWT

        LOGGER.debug("Token issued at: {}", issuedAt);
        LOGGER.debug("Token expires at: {}", expiryDate);
        LOGGER.info("END - generateToken(). Token generated successfully.");
        return token;
    }

    /**
     * Validates a JWT token and extracts the username (subject).
     *
     * @param token the JWT token string to validate
     * @return the username extracted from the token's 'sub' claim
     */
    public String extractUsername(String token) {
        LOGGER.debug("Extracting username from token");

        SecretKey signingKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );

        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
