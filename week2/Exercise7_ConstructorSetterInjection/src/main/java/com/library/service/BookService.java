package com.library.service;

import com.library.repository.BookRepository;

/**
 * BookService - Service layer for library book management.
 * Exercise 7: Implementing Constructor and Setter Injection
 *
 * This class demonstrates BOTH types of Spring dependency injection:
 *
 * 1. CONSTRUCTOR INJECTION:
 *    - BookRepository is injected via the parameterized constructor.
 *    - Configured in XML with: <constructor-arg ref="bookRepository"/>
 *    - Guarantees the dependency is available at object creation time.
 *    - Ideal for mandatory dependencies.
 *
 * 2. SETTER INJECTION:
 *    - libraryName is injected via the setLibraryName() setter method.
 *    - Configured in XML with: <property name="libraryName" value="..."/>
 *    - Allows optional dependencies and supports re-injection.
 *    - Ideal for optional or reconfigurable dependencies.
 */
public class BookService {

    // ====== CONSTRUCTOR INJECTION dependency ======
    private final BookRepository bookRepository;

    // ====== SETTER INJECTION dependency ======
    private String libraryName;

    /**
     * CONSTRUCTOR INJECTION: Spring calls this constructor and passes
     * the BookRepository bean as configured with <constructor-arg>.
     *
     * @param bookRepository the BookRepository to inject (mandatory dependency)
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[Constructor Injection] BookService created.");
        System.out.println("[Constructor Injection] BookRepository injected via constructor.");
    }

    /**
     * SETTER INJECTION: Spring calls this setter after construction
     * to inject the libraryName value from <property name="libraryName">.
     *
     * @param libraryName the name of the library (optional dependency)
     */
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        System.out.println("[Setter Injection] libraryName injected via setter -> " + libraryName);
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public String getLibraryName() {
        return libraryName;
    }

    /**
     * Business logic to list all available books.
     */
    public void listBooks() {
        System.out.println("BookService [" + libraryName + "]: Listing all books...");
        bookRepository.getAllBooks();
    }

    /**
     * Business logic to add a book.
     *
     * @param title book title
     */
    public void addBook(String title) {
        System.out.println("BookService [" + libraryName + "]: Adding book -> " + title);
        bookRepository.saveBook(title);
    }
}
