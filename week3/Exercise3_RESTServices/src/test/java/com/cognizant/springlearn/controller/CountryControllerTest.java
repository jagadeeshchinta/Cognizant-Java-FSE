package com.cognizant.springlearn.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * CountryControllerTest - MockMVC integration tests for Country REST endpoints.
 * Exercise 3: End-to-End Testing using MockMVC
 *
 * Tests Covered:
 * 1. GET /country             → Returns India as JSON (200 OK)
 * 2. GET /countries/in        → Returns India by lowercase code (200 OK)
 * 3. GET /countries/IN        → Returns India by uppercase code (200 OK)
 * 4. GET /countries/us        → Returns United States (200 OK)
 * 5. GET /countries/de        → Returns Germany (200 OK)
 * 6. GET /countries/jp        → Returns Japan (200 OK)
 * 7. GET /countries/xx        → Unknown code returns 400 Bad Request
 *
 * jsonPath() assertions:
 * - jsonPath("$.code").exists()      → Verifies the 'code' field exists in JSON
 * - jsonPath("$.code").value("IN")   → Verifies 'code' field equals "IN"
 * - status().isOk()                  → Verifies HTTP 200
 * - status().isBadRequest()          → Verifies HTTP 400
 */
@SpringBootTest
@AutoConfigureMockMvc
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ===== Test: GET /country =====

    /**
     * Test: GET /country returns India country details as JSON with HTTP 200 OK
     */
    @Test
    void testGetCountryIndia_Returns200WithIndiaJson() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())                        // HTTP 200 OK
                .andExpect(jsonPath("$.code").exists())             // 'code' field exists
                .andExpect(jsonPath("$.code").value("IN"))          // code = "IN"
                .andExpect(jsonPath("$.name").exists())             // 'name' field exists
                .andExpect(jsonPath("$.name").value("India"));      // name = "India"
    }

    // ===== Tests: GET /countries/{code} =====

    /**
     * Test: GET /countries/in (lowercase) returns India — case-insensitive matching
     */
    @Test
    void testGetCountry_LowercaseCode_ReturnsIndia() throws Exception {
        mockMvc.perform(get("/countries/in"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    /**
     * Test: GET /countries/IN (uppercase) returns India
     */
    @Test
    void testGetCountry_UppercaseCode_ReturnsIndia() throws Exception {
        mockMvc.perform(get("/countries/IN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    /**
     * Test: GET /countries/us returns United States
     */
    @Test
    void testGetCountry_US_ReturnsUnitedStates() throws Exception {
        mockMvc.perform(get("/countries/us"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("US"))
                .andExpect(jsonPath("$.name").value("United States"));
    }

    /**
     * Test: GET /countries/de returns Germany
     */
    @Test
    void testGetCountry_DE_ReturnsGermany() throws Exception {
        mockMvc.perform(get("/countries/de"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("DE"))
                .andExpect(jsonPath("$.name").value("Germany"));
    }

    /**
     * Test: GET /countries/jp returns Japan
     */
    @Test
    void testGetCountry_JP_ReturnsJapan() throws Exception {
        mockMvc.perform(get("/countries/jp"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("JP"))
                .andExpect(jsonPath("$.name").value("Japan"));
    }

    /**
     * Test: GET /countries/xx (unknown code) returns 400 Bad Request
     */
    @Test
    void testGetCountry_UnknownCode_Returns400() throws Exception {
        mockMvc.perform(get("/countries/xx"))
                .andExpect(status().isBadRequest());    // HTTP 400 Bad Request
    }
}
