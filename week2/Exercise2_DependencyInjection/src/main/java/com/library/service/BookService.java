package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookService - Service layer for library book management.
 * Exercise 2: Implementing Dependency Injection
 *
 * Spring injects the BookRepository dependency via the setter method,
 * demonstrating Setter-based Dependency Injection (DI).
 */
public class BookService {

    // Dependency on BookRepository (injected by Spring)
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService bean instantiated by Spring IoC container.");
    }

    /**
     * Setter method for BookRepository dependency injection.
     * Spring calls this method automatically when configured with
     * <property name="bookRepository" ref="bookRepository"/> in XML.
     *
     * @param bookRepository the repository to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter injection.");
    }

    /**
     * Returns the injected BookRepository.
     *
     * @return the BookRepository instance
     */
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    /**
     * Business logic to list all available books.
     * Delegates the data retrieval to BookRepository.
     */
    public void listBooks() {
        System.out.println("BookService: Requesting book list...");
        if (bookRepository != null) {
            bookRepository.getAllBooks();
        } else {
            System.out.println("BookService: BookRepository is not injected!");
        }
    }

    /**
     * Business logic to add a new book.
     * Delegates the save operation to BookRepository.
     *
     * @param title the title of the book to add
     */
    public void addBook(String title) {
        System.out.println("BookService: Adding book -> " + title);
        if (bookRepository != null) {
            bookRepository.saveBook(title);
        }
    }
}
