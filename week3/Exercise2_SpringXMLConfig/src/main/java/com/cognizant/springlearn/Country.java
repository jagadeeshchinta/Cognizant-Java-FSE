package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country - Domain class representing a country for the airline booking application.
 * Exercise 2: Spring Core - Load Country from Spring XML Configuration
 *
 * This class is used as a Spring bean configured in country.xml.
 * Spring's IoC container instantiates this class and injects values via setter injection.
 *
 * Countries supported:
 *   US - United States
 *   DE - Germany
 *   IN - India
 *   JP - Japan
 */
public class Country {

    // SLF4J Logger - Spring Boot auto-configures Logback as the logging implementation
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    // ===== Instance Variables =====

    /** Two-character ISO 3166-1 alpha-2 country code (e.g., "IN", "US") */
    private String code;

    /** Full name of the country (e.g., "India", "United States") */
    private String name;

    // ===== Constructors =====

    /**
     * Default no-arg constructor.
     * REQUIRED by Spring IoC container to instantiate the bean.
     * Spring first calls this constructor, then injects values via setters.
     */
    public Country() {
        // Debug log to verify when Spring invokes the constructor
        LOGGER.debug("Inside Country Constructor.");
    }

    // ===== Getters and Setters =====
    // Spring calls these setters when processing <property> tags in country.xml

    /**
     * Returns the ISO country code.
     * @return two-character country code
     */
    public String getCode() {
        LOGGER.debug("Inside getCode(). Code = {}", code);
        return code;
    }

    /**
     * Sets the ISO country code.
     * Called by Spring when processing: <property name="code" value="IN"/>
     * @param code two-character ISO country code
     */
    public void setCode(String code) {
        LOGGER.debug("Inside setCode(). Setting code = {}", code);
        this.code = code;
    }

    /**
     * Returns the full country name.
     * @return full name of the country
     */
    public String getName() {
        LOGGER.debug("Inside getName(). Name = {}", name);
        return name;
    }

    /**
     * Sets the full country name.
     * Called by Spring when processing: <property name="name" value="India"/>
     * @param name full country name
     */
    public void setName(String name) {
        LOGGER.debug("Inside setName(). Setting name = {}", name);
        this.name = name;
    }

    // ===== toString =====

    /**
     * Returns a string representation of the Country object.
     * Used in logging to display country details.
     */
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
