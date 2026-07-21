package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CountryController - REST Controller for country-related endpoints.
 * Exercise 3: REST - Country Web Service
 *
 * Endpoints:
 * 1. GET /country          → Returns India country details as JSON
 * 2. GET /countries/{code} → Returns country by ISO code (case-insensitive)
 *
 * How the Country bean is converted to JSON:
 * - @RestController includes @ResponseBody on every method
 * - Spring Boot auto-configures Jackson (ObjectMapper)
 * - Jackson serializes the Country object by reading its getters:
 *   getCode() → "code" field, getName() → "name" field
 * - Result: {"code":"IN","name":"India"}
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // Spring injects CountryService via constructor injection
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * getCountryIndia() - Returns India's country details.
     *
     * Method Annotation : @RequestMapping (maps to GET /country by default)
     * Method             : GET
     * URL                : http://localhost:8083/country
     *
     * Sample Response:
     * {
     *   "code": "IN",
     *   "name": "India"
     * }
     *
     * @return Country object (auto-serialized to JSON by Jackson)
     */
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");

        Country country = countryService.getCountryIndia();

        LOGGER.info("END - getCountryIndia(). Returning: {}", country);
        return country;
    }

    /**
     * getCountry() - Returns country details for a given ISO code.
     *
     * Method Annotation : @GetMapping("/countries/{code}")
     * Method             : GET
     * URL                : http://localhost:8083/countries/{code}
     *
     * {code} is a path variable (case-insensitive matching is done in service layer).
     *
     * Sample Request : http://localhost:8083/countries/in
     * Sample Response:
     * {
     *   "code": "IN",
     *   "name": "India"
     * }
     *
     * @param code ISO country code from URL path (e.g., "in", "IN", "us")
     * @return 200 OK with Country JSON, or 400 Bad Request if not found
     */
    @GetMapping("/countries/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry(). Code from URL: {}", code);

        Country country = countryService.getCountry(code);

        if (country == null) {
            LOGGER.warn("Country not found for code: {}", code);
            LOGGER.info("END - getCountry(). Returning 400 Bad Request.");
            return ResponseEntity.badRequest().build();
        }

        LOGGER.info("END - getCountry(). Returning: {}", country);
        return ResponseEntity.ok(country);
    }
}
