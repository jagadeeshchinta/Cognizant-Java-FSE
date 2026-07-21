package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main entry point.
 * Exercise 2: Implementing Dependency Injection
 *
 * Loads the Spring ApplicationContext and verifies that
 * BookRepository is correctly injected into BookService via setter injection.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Exercise 2: Implementing Dependency Injection ===");
        System.out.println("Loading Spring ApplicationContext...");

        // Load Spring context from the XML configuration file
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring Context loaded successfully!");
        System.out.println("-----------------------------------------------------");

        // Retrieve BookService bean - BookRepository will already be injected by Spring
        BookService bookService = (BookService) context.getBean("bookService");

        // Verify that dependency injection worked
        if (bookService.getBookRepository() != null) {
            System.out.println("\n[SUCCESS] BookRepository has been successfully injected into BookService!");
        } else {
            System.out.println("\n[FAILURE] BookRepository injection FAILED!");
        }

        System.out.println("\n--- Testing Service Methods ---");
        bookService.listBooks();
        bookService.addBook("Spring in Action");
        bookService.addBook("Clean Code");

        System.out.println("-----------------------------------------------------");
        System.out.println("Dependency Injection verified successfully.");

        // Close context and release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}
