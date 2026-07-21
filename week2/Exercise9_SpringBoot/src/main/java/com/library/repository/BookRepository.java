package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * BookRepository - Spring Data JPA Repository Interface.
 * Exercise 9: Creating a Spring Boot Application
 *
 * Extends JpaRepository which provides built-in CRUD operations:
 * - save(entity)          → INSERT or UPDATE
 * - findById(id)          → SELECT by primary key
 * - findAll()             → SELECT all records
 * - deleteById(id)        → DELETE by primary key
 * - count()               → COUNT records
 * - existsById(id)        → Check existence
 *
 * Spring Data JPA automatically generates the implementation at runtime.
 * No implementation class is needed - Spring creates it via a dynamic proxy.
 *
 * @Repository marks this as a Spring Data repository component.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Find all books by a specific author.
     * Spring Data JPA automatically generates the query from the method name:
     * SELECT * FROM books WHERE author = ?
     *
     * @param author the author name to search for
     * @return list of books by the given author
     */
    List<Book> findByAuthor(String author);

    /**
     * Find a book by its ISBN.
     * SELECT * FROM books WHERE isbn = ?
     *
     * @param isbn the ISBN to search for
     * @return Optional containing the book if found
     */
    Optional<Book> findByIsbn(String isbn);

    /**
     * Find books whose title contains a keyword (case-insensitive).
     * SELECT * FROM books WHERE LOWER(title) LIKE LOWER('%keyword%')
     *
     * @param keyword the keyword to search for in titles
     * @return list of matching books
     */
    List<Book> findByTitleContainingIgnoreCase(String keyword);
}
