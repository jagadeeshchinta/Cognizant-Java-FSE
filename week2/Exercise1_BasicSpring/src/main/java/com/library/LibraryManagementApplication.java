package com.library;

import com.library.service.BookService;
import com.library.repository.BookRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * LibraryManagementApplication - Main entry point.
 * Exercise 1: Configuring a Basic Spring Application
 *
 * Loads the Spring ApplicationContext from applicationContext.xml
 * and tests that beans are correctly created and managed.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Basic Spring Application ===");
        System.out.println("Loading Spring ApplicationContext...");

        // Load the Spring application context from the XML configuration file
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\nSpring Context loaded successfully!");
        System.out.println("------------------------------------------");

        // Retrieve the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.listBooks();

        // Retrieve the BookRepository bean from the context
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.getAllBooks();

        System.out.println("------------------------------------------");
        System.out.println("All beans configured and tested successfully.");

        // Close the context to release resources
        ((ClassPathXmlApplicationContext) context).close();
    }
}
