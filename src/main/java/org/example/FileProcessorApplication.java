package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FileProcessorApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(FileProcessorApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FileProcessorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Started...");

        log.info("Finished");
    }
}