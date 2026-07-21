package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LibraryManagementApplication - Spring Boot Application Entry Point.
 * Exercise 9: Creating a Spring Boot Application
 *
 * @SpringBootApplication is a convenience annotation that combines:
 * - @Configuration     : marks this as a Spring configuration class
 * - @EnableAutoConfiguration : enables Spring Boot auto-configuration
 * - @ComponentScan    : scans com.library package for Spring components
 *
 * The embedded Tomcat server starts on port 8080 (configured in application.properties).
 */
@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("\n======================================================");
        System.out.println("  Library Management API is running!");
        System.out.println("  Base URL  : http://localhost:8080/api/books");
        System.out.println("  H2 Console: http://localhost:8080/h2-console");
        System.out.println("======================================================\n");
    }
}
