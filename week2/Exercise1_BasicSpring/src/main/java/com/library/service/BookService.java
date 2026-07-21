package com.library.service;

/**
 * BookService - Service layer for library book management.
 * Exercise 1: Basic Spring Application
 */
public class BookService {

    public BookService() {
        System.out.println("BookService bean created by Spring IoC container.");
    }

    /**
     * Business logic to list all available books.
     */
    public void listBooks() {
        System.out.println("BookService: Listing all books.");
    }
}
