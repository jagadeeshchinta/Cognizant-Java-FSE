package com.library.repository;

/**
 * BookRepository - Data access layer for managing books.
 * Exercise 2: Implementing Dependency Injection
 */
public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean instantiated by Spring IoC container.");
    }

    /**
     * Simulates fetching all books from a data source.
     */
    public void getAllBooks() {
        System.out.println("BookRepository: Fetching all books from the data source.");
    }

    /**
     * Simulates saving a book.
     *
     * @param title the title of the book to save
     */
    public void saveBook(String title) {
        System.out.println("BookRepository: Saving book -> " + title);
    }
}
