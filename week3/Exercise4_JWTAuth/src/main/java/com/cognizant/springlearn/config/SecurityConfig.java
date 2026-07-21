package com.cognizant.springlearn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig - Spring Security Configuration.
 * Exercise 4: JWT Authentication
 *
 * @Configuration     : Marks as Spring configuration class
 * @EnableWebSecurity : Enables Spring Security's web security support
 *
 * This class:
 * 1. Configures in-memory authentication with user credentials
 * 2. Configures URL authorization - /authenticate is publicly accessible
 * 3. Enables HTTP Basic Authentication so credentials can be sent via -u option
 *
 * JWT Process Flow:
 * Step 1: Client sends GET /authenticate with Basic Auth header
 *         Authorization: Basic dXNlcjpwd2Q=  (Base64 encoded "user:pwd")
 * Step 2: Spring Security intercepts, validates credentials via AuthenticationManager
 * Step 3: AuthController reads the Authorization header, decodes username/password
 * Step 4: AuthController generates JWT via JwtUtil and returns {"token":"..."}
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    /**
     * Configure In-Memory Authentication.
     *
     * In production, replace with database authentication or LDAP.
     * Here we use a simple in-memory user store for demonstration.
     *
     * Credentials: username=user, password=pwd
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.debug("Configuring in-memory authentication");

        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("pwd"))
                .roles("USER");
    }

    /**
     * Configure URL Authorization and HTTP Security.
     *
     * antMatchers("/authenticate") - Permit all (no auth needed to get a token)
     * anyRequest().authenticated() - All other endpoints require a valid JWT
     * httpBasic()                  - Enable Basic Auth for the /authenticate endpoint
     * csrf().disable()             - Disable CSRF for REST APIs (stateless)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.debug("Configuring HTTP security rules");

        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/authenticate").permitAll()  // Public endpoint
                .anyRequest().authenticated()              // Secure everything else
            .and()
            .httpBasic();                                  // Enable Basic Auth header parsing
    }

    /**
     * BCryptPasswordEncoder bean.
     * BCrypt is a strong adaptive hashing function for storing passwords securely.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
