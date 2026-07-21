package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main entry point.
 * Exercise 5: Configuring the Spring IoC Container
 *
 * Loads Spring context and verifies beans are configured
 * and wired correctly by the IoC container.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Configuring the Spring IoC Container ===");
        System.out.println("Loading Spring ApplicationContext from applicationContext.xml...\n");

        // Load the Spring IoC container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring IoC Container started successfully!");
        System.out.println("--------------------------------------------------------");

        // Retrieve BookService - BookRepository already wired by Spring IoC
        BookService bookService = (BookService) context.getBean("bookService");

        // Verify IoC container wired the dependency
        System.out.println("\n[CHECK] BookRepository injected: "
                + (bookService.getBookRepository() != null ? "YES ✓" : "NO ✗"));

        System.out.println("\n--- Calling Service Methods ---");
        bookService.listBooks();
        bookService.addBook("Effective Java");
        bookService.addBook("Design Patterns");

        System.out.println("--------------------------------------------------------");
        System.out.println("Spring IoC Container configuration verified successfully.");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
