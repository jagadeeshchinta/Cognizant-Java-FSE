# Exercise 4 - Creating and Configuring a Maven Project

## Overview
This exercise demonstrates how to set up a Maven project for the Library Management 
application and configure it with Spring dependencies.

## Project Structure
```
Exercise4_MavenProject/
└── pom.xml                   ← The only deliverable for this exercise
```

## What Was Done
This exercise focuses entirely on the **pom.xml** configuration.

### Dependencies Added
| Dependency | Group ID | Purpose |
|---|---|---|
| spring-context | org.springframework | Spring IoC container, ApplicationContext |
| spring-aop | org.springframework | Aspect-Oriented Programming support |
| spring-webmvc | org.springframework | Spring MVC web framework |
| spring-web | org.springframework | Core web utilities |
| javax.servlet-api | javax.servlet | Servlet API (runtime provided by container) |

### Maven Plugins Configured
| Plugin | Version | Purpose |
|---|---|---|
| maven-compiler-plugin | 3.8.1 | Compile Java sources targeting Java 1.8 |
| maven-surefire-plugin | 2.22.2 | Run unit tests during build |

## Key pom.xml Configuration
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <encoding>UTF-8</encoding>
    </configuration>
</plugin>
```

## How to Build
```bash
mvn clean compile
mvn dependency:tree    # View all resolved dependencies
```
