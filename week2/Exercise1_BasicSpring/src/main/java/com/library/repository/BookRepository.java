package com.library.repository;

/**
 * BookRepository - Data access layer for managing books.
 * Exercise 1: Basic Spring Application
 */
public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository bean created by Spring IoC container.");
    }

    /**
     * Simulates fetching all books from a data source.
     */
    public void getAllBooks() {
        System.out.println("BookRepository: Fetching all books from the data source.");
    }

    /**
     * Simulates saving a book to the data source.
     *
     * @param title the title of the book to save
     */
    public void saveBook(String title) {
        System.out.println("BookRepository: Saving book -> " + title);
    }
}
