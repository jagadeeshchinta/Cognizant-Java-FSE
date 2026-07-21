package com.library.config;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * DataInitializer - Loads sample book data on application startup.
 * Exercise 9: Creating a Spring Boot Application
 *
 * Implements CommandLineRunner so Spring Boot calls run() after the
 * ApplicationContext is loaded, populating the H2 in-memory database
 * with sample books for testing the REST API.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing sample book data...");

        bookRepository.save(new Book(
                "Spring in Action",
                "Craig Walls",
                "978-1617294945",
                2022,
                45.99
        ));

        bookRepository.save(new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991",
                2018,
                52.49
        ));

        bookRepository.save(new Book(
                "Clean Code",
                "Robert C. Martin",
                "978-0132350884",
                2008,
                38.75
        ));

        bookRepository.save(new Book(
                "Head First Design Patterns",
                "Eric Freeman",
                "978-0596007126",
                2004,
                44.99
        ));

        bookRepository.save(new Book(
                "The Pragmatic Programmer",
                "Andrew Hunt",
                "978-0135957059",
                2019,
                49.95
        ));

        System.out.println("Sample data loaded: " + bookRepository.count() + " books available.");
    }
}
