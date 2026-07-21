package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country - Domain class representing a country.
 * Exercise 3: REST Services
 *
 * When returned from a @RestController method, Spring's Jackson library
 * automatically serializes this object to JSON:
 * { "code": "IN", "name": "India" }
 */
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode(). Code = {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode(). Setting code = {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName(). Name = {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName(). Setting name = {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
