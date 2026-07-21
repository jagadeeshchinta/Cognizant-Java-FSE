package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringLearnApplication - Main entry point.
 * Exercise 2: Spring Core - Load Country from Spring Configuration XML
 *
 * Demonstrates:
 * - Loading a Spring XML configuration file (country.xml)
 * - Retrieving a bean from the ApplicationContext
 * - Observing how Spring calls the constructor and setter methods
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START - SpringLearnApplication main() method");

        SpringApplication.run(SpringLearnApplication.class, args);

        // Invoke the displayCountry method to demonstrate Spring XML bean loading
        displayCountry();

        LOGGER.info("END - SpringLearnApplication main() method");
    }

    /**
     * displayCountry() - Reads the country bean from country.xml and displays details.
     *
     * How it works:
     * 1. ClassPathXmlApplicationContext reads country.xml from the classpath
     * 2. Spring IoC container parses <bean> tags and creates objects
     * 3. For each <property>, Spring calls the corresponding setter method
     * 4. context.getBean("country", Country.class) retrieves the managed bean
     *
     * What you will see in logs when executed:
     * - "Inside Country Constructor." (Spring calls no-arg constructor)
     * - "Inside setCode(). Setting code = IN" (Spring calls setCode())
     * - "Inside setName(). Setting name = India" (Spring calls setName())
     * - "Country : Country{code='IN', name='India'}" (our log output)
     */
    private static void displayCountry() {
        LOGGER.info("START - displayCountry()");

        // Step 1: Load the Spring configuration XML file from the classpath
        // ClassPathXmlApplicationContext is an implementation of ApplicationContext
        // It reads the XML, creates beans, and injects dependencies
        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        // Step 2: Retrieve the 'country' bean from the IoC container
        // Spring returns the same singleton instance every time (default scope)
        Country country = context.getBean("country", Country.class);

        // Step 3: Log the country details
        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("END - displayCountry()");
    }
}
