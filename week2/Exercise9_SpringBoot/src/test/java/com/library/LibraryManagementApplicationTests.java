package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * LibraryManagementApplicationTests - Integration tests for the REST API.
 * Exercise 9: Creating a Spring Boot Application
 *
 * @SpringBootTest: Loads the full application context for integration testing.
 * @AutoConfigureMockMvc: Configures MockMvc to test HTTP layer without a real server.
 */
@SpringBootTest
@AutoConfigureMockMvc
class LibraryManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Book testBook;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        testBook = bookRepository.save(
                new Book("Test Book", "Test Author", "978-0000000001", 2023, 29.99)
        );
    }

    // ===== GET All Books =====
    @Test
    void testGetAllBooks_ReturnsOk() throws Exception {
        mockMvc.perform(get("/api/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].title", is("Test Book")));
    }

    // ===== GET Book by ID =====
    @Test
    void testGetBookById_ReturnsBook() throws Exception {
        mockMvc.perform(get("/api/books/" + testBook.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Test Book")))
                .andExpect(jsonPath("$.author", is("Test Author")));
    }

    // ===== GET Book by ID - Not Found =====
    @Test
    void testGetBookById_NotFound() throws Exception {
        mockMvc.perform(get("/api/books/9999"))
                .andExpect(status().isNotFound());
    }

    // ===== POST Create Book =====
    @Test
    void testCreateBook_ReturnsCreated() throws Exception {
        Book newBook = new Book("New Book", "New Author", "978-0000000002", 2024, 34.99);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newBook)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.title", is("New Book")))
                .andExpect(jsonPath("$.author", is("New Author")));
    }

    // ===== PUT Update Book =====
    @Test
    void testUpdateBook_ReturnsUpdated() throws Exception {
        testBook.setTitle("Updated Title");
        testBook.setPrice(39.99);

        mockMvc.perform(put("/api/books/" + testBook.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Updated Title")))
                .andExpect(jsonPath("$.price", is(39.99)));
    }

    // ===== DELETE Book =====
    @Test
    void testDeleteBook_ReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/books/" + testBook.getId()))
                .andExpect(status().isNoContent());
    }

    // ===== DELETE Book - Not Found =====
    @Test
    void testDeleteBook_NotFound() throws Exception {
        mockMvc.perform(delete("/api/books/9999"))
                .andExpect(status().isNotFound());
    }

    // ===== Search by title =====
    @Test
    void testSearchByTitle_ReturnsMatches() throws Exception {
        mockMvc.perform(get("/api/books/search?title=Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
    }
}
