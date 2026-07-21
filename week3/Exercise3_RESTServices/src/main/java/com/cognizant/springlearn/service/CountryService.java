package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CountryService - Service layer for country operations.
 * Exercise 3: REST - Get country based on country code
 *
 * @Service marks this as a Spring-managed service component.
 * Business logic is kept here, not in the controller (separation of concerns).
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    /**
     * Loads the full list of countries from country.xml and
     * returns the country whose code matches the given code (case-insensitive).
     *
     * Implementation Steps:
     * 1. Load country.xml via ClassPathXmlApplicationContext
     * 2. Retrieve the 'countryList' bean (ArrayList of Country objects)
     * 3. Iterate through the list
     * 4. Compare codes case-insensitively using equalsIgnoreCase()
     * 5. Return the matching country (or null if not found)
     *
     * @param code the ISO country code to search for (case-insensitive)
     * @return the matching Country, or null if not found
     */
    @SuppressWarnings("unchecked")
    public Country getCountry(String code) {
        LOGGER.info("START - getCountry(). Searching for code: {}", code);

        // Load Spring XML configuration
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        // Retrieve the list of all countries
        List<Country> countryList =
                (List<Country>) context.getBean("countryList");

        LOGGER.debug("Total countries loaded: {}", countryList.size());

        // Use lambda expression to find the matching country (case-insensitive)
        Country result = countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);

        if (result != null) {
            LOGGER.debug("Found country: {}", result.toString());
        } else {
            LOGGER.warn("No country found for code: {}", code);
        }

        LOGGER.info("END - getCountry()");
        return result;
    }

    /**
     * Loads and returns India's country details from country.xml.
     * Used by the /country endpoint.
     *
     * @return Country object for India
     */
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia()");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);

        LOGGER.debug("Country loaded: {}", country.toString());
        LOGGER.info("END - getCountryIndia()");
        return country;
    }
}
