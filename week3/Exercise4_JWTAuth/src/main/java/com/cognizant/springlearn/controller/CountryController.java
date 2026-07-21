package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CountryController - REST Controller (carried forward from Exercise 3).
 * Exercise 4: Endpoints now secured by JWT via Spring Security.
 *
 * To access secured endpoints, include the JWT in the request:
 *   Authorization: Bearer <token>
 *
 * Flow:
 * 1. GET /authenticate with Basic Auth → receive JWT
 * 2. GET /country with "Authorization: Bearer <token>" → receive country JSON
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");
        Country country = countryService.getCountryIndia();
        LOGGER.info("END - getCountryIndia()");
        return country;
    }

    @GetMapping("/countries/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        LOGGER.info("START - getCountry(). Code: {}", code);
        Country country = countryService.getCountry(code);
        if (country == null) {
            LOGGER.warn("Country not found for code: {}", code);
            return ResponseEntity.badRequest().build();
        }
        LOGGER.info("END - getCountry(). Found: {}", country);
        return ResponseEntity.ok(country);
    }
}
