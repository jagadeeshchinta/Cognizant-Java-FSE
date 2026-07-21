package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main entry point.
 * Exercise 7: Implementing Constructor and Setter Injection
 *
 * Verifies that Spring correctly performs:
 * 1. CONSTRUCTOR INJECTION: BookRepository passed to BookService constructor.
 * 2. SETTER INJECTION: libraryName value injected via setLibraryName() setter.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Constructor and Setter Injection ===");
        System.out.println("Loading Spring ApplicationContext...\n");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring Context loaded successfully!");
        System.out.println("----------------------------------------------------");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // ===== VERIFY CONSTRUCTOR INJECTION =====
        System.out.println("\n[CONSTRUCTOR INJECTION VERIFICATION]");
        if (bookService.getBookRepository() != null) {
            System.out.println("  ✓ BookRepository successfully injected via Constructor.");
        } else {
            System.out.println("  ✗ Constructor injection FAILED for BookRepository!");
        }

        // ===== VERIFY SETTER INJECTION =====
        System.out.println("\n[SETTER INJECTION VERIFICATION]");
        if (bookService.getLibraryName() != null && !bookService.getLibraryName().isEmpty()) {
            System.out.println("  ✓ libraryName successfully injected via Setter: "
                    + bookService.getLibraryName());
        } else {
            System.out.println("  ✗ Setter injection FAILED for libraryName!");
        }

        // ===== TEST SERVICE METHODS =====
        System.out.println("\n--- Testing Service Methods ---");
        bookService.listBooks();
        bookService.addBook("Head First Design Patterns");
        bookService.addBook("The Pragmatic Programmer");

        System.out.println("----------------------------------------------------");
        System.out.println("Both Constructor and Setter Injection verified.");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
