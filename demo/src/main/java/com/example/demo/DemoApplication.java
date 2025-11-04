package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(DemoApplication.class.getName());

    private final Environment env;

    public DemoApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        log.info(" Starting Spring Boot Application...");
        SpringApplication.run(DemoApplication.class, args);
        long total = System.currentTimeMillis() - startTime;
        log.info(" Application started successfully in " + total + "ms");
    }

    @Override
    public void run(String... args) throws Exception {
        long runStart = System.currentTimeMillis();
        log.info("  Running post-startup tasks...");

        String port = env.getProperty("server.port", "8080");
        String dbUrl = env.getProperty("spring.datasource.url");
        String ddlAuto = env.getProperty("spring.jpa.hibernate.ddl-auto");

        log.info(" Server running on: http://localhost:" + port + "/api");
        log.info("  Database URL: " + dbUrl);
        log.info("  Hibernate ddl-auto: " + ddlAuto);

        long done = System.currentTimeMillis() - runStart;
        log.info(" Bootstrap completed in " + done + "ms");
    }
}
