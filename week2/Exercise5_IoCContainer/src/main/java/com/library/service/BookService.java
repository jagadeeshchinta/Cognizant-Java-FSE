package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookService - Service layer for library book management.
 * Exercise 5: Configuring the Spring IoC Container
 *
 * Demonstrates Setter-based Dependency Injection managed by the Spring IoC container.
 */
public class BookService {

    // Injected by Spring IoC container via setter method
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("[IoC] BookService bean created by Spring container.");
    }

    /**
     * Setter method used by Spring IoC to inject the BookRepository dependency.
     * Configured in applicationContext.xml with:
     *   <property name="bookRepository" ref="bookRepository"/>
     *
     * @param bookRepository the BookRepository instance to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[IoC] Spring injected BookRepository into BookService via setter.");
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    /**
     * Lists all books by delegating to the repository.
     */
    public void listBooks() {
        System.out.println("BookService: Processing request to list all books...");
        bookRepository.getAllBooks();
    }

    /**
     * Adds a new book by delegating to the repository.
     *
     * @param title book title
     */
    public void addBook(String title) {
        System.out.println("BookService: Processing request to add book -> " + title);
        bookRepository.saveBook(title);
    }
}
