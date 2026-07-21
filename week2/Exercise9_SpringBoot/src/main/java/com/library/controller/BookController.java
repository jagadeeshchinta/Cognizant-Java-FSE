package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController - REST API Controller for managing books.
 * Exercise 9: Creating a Spring Boot Application
 *
 * @RestController: combines @Controller + @ResponseBody (auto-serialize to JSON)
 * @RequestMapping: base URL for all endpoints in this controller
 *
 * REST Endpoints:
 * ┌──────────────────────────────────────────────────────────────────┐
 * │  Method  │  URL                          │  Description          │
 * ├──────────┼───────────────────────────────┼───────────────────────┤
 * │  GET     │  /api/books                   │  Get all books        │
 * │  GET     │  /api/books/{id}              │  Get book by ID       │
 * │  GET     │  /api/books/search?title=     │  Search by title      │
 * │  GET     │  /api/books/author/{author}   │  Get books by author  │
 * │  POST    │  /api/books                   │  Create new book      │
 * │  PUT     │  /api/books/{id}              │  Update existing book │
 * │  DELETE  │  /api/books/{id}              │  Delete book          │
 * └──────────┴───────────────────────────────┴───────────────────────┘
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    /**
     * Constructor injection: Spring injects BookService automatically.
     *
     * @param bookService the service layer for book operations
     */
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // ============================================================
    // GET /api/books — Retrieve all books
    // ============================================================

    /**
     * Retrieves a list of all books in the library.
     *
     * @return 200 OK with list of all books
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // ============================================================
    // GET /api/books/{id} — Retrieve a book by ID
    // ============================================================

    /**
     * Retrieves a single book by its ID.
     *
     * @param id the book ID from the URL path
     * @return 200 OK with the book, or 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }

    // ============================================================
    // GET /api/books/search?title=keyword — Search books by title
    // ============================================================

    /**
     * Searches for books whose title contains the given keyword (case-insensitive).
     *
     * @param title the keyword to search in book titles
     * @return 200 OK with matching books list
     */
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    // ============================================================
    // GET /api/books/author/{author} — Get books by author
    // ============================================================

    /**
     * Retrieves all books written by a specific author.
     *
     * @param author the author name from the URL path
     * @return 200 OK with list of books by the author
     */
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    // ============================================================
    // POST /api/books — Create a new book
    // ============================================================

    /**
     * Creates a new book in the library.
     *
     * Request Body (JSON example):
     * {
     *   "title": "Spring in Action",
     *   "author": "Craig Walls",
     *   "isbn": "978-1617294945",
     *   "publicationYear": 2022,
     *   "price": 45.99
     * }
     *
     * @param book the book data from the request body
     * @return 201 Created with the saved book (including generated ID)
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // ============================================================
    // PUT /api/books/{id} — Update an existing book
    // ============================================================

    /**
     * Updates an existing book identified by its ID.
     *
     * @param id          the ID of the book to update (from URL path)
     * @param bookDetails the updated book data (from request body)
     * @return 200 OK with the updated book, or 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                           @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails)
                .map(updatedBook -> ResponseEntity.ok(updatedBook))
                .orElse(ResponseEntity.notFound().build());
    }

    // ============================================================
    // DELETE /api/books/{id} — Delete a book
    // ============================================================

    /**
     * Deletes a book from the library by its ID.
     *
     * @param id the ID of the book to delete (from URL path)
     * @return 204 No Content if deleted, or 404 Not Found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();  // 204 No Content
        } else {
            return ResponseEntity.notFound().build();    // 404 Not Found
        }
    }
}
