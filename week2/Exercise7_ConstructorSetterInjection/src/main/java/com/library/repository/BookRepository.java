package com.library.repository;

/**
 * BookRepository - Data access layer for managing books.
 * Exercise 7: Constructor and Setter Injection
 */
public class BookRepository {

    public BookRepository() {
        System.out.println("[Constructor] BookRepository created by Spring IoC container.");
    }

    public void getAllBooks() {
        System.out.println("BookRepository: Fetching all books from the data source.");
    }

    public void saveBook(String title) {
        System.out.println("BookRepository: Saving book -> " + title);
    }
}
