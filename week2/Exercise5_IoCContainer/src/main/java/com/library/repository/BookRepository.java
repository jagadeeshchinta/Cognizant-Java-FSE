package com.library.repository;

/**
 * BookRepository - Data access layer for managing books.
 * Exercise 5: Configuring the Spring IoC Container
 */
public class BookRepository {

    public BookRepository() {
        System.out.println("[IoC] BookRepository bean created by Spring container.");
    }

    public void getAllBooks() {
        System.out.println("BookRepository: Fetching all books from the database.");
    }

    public void saveBook(String title) {
        System.out.println("BookRepository: Persisting book -> " + title);
    }
}
