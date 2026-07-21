package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BookService - Business logic layer for the Library Management application.
 * Exercise 9: Creating a Spring Boot Application
 *
 * @Service marks this as a Spring-managed service component.
 * Spring's @Autowired injects the BookRepository dependency automatically.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Constructor injection via @Autowired.
     * Spring automatically provides the BookRepository bean.
     *
     * @param bookRepository the JPA repository for Book entities
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieve all books from the database.
     *
     * @return list of all Book entities
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieve a single book by its ID.
     *
     * @param id the book ID
     * @return Optional containing the book if found
     */
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    /**
     * Create or save a new book.
     *
     * @param book the Book entity to save
     * @return the persisted Book with generated ID
     */
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Update an existing book by ID.
     * Returns the updated book or empty if not found.
     *
     * @param id          the ID of the book to update
     * @param bookDetails the new book data
     * @return Optional containing the updated Book
     */
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setIsbn(bookDetails.getIsbn());
            existingBook.setPublicationYear(bookDetails.getPublicationYear());
            existingBook.setPrice(bookDetails.getPrice());
            return bookRepository.save(existingBook);
        });
    }

    /**
     * Delete a book by ID.
     *
     * @param id the ID of the book to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Find books by author name.
     *
     * @param author the author name to search
     * @return list of matching books
     */
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    /**
     * Search books by title keyword (case-insensitive).
     *
     * @param keyword search keyword
     * @return list of matching books
     */
    public List<Book> searchBooksByTitle(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
