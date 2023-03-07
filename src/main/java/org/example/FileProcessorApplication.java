package org.example;

import org.example.configuration.FileProcessorConfiguration;
import org.example.processors.PersonProcessorInitializer;
import org.example.services.FileProcessorService;
import org.example.state.FileProcessorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(FileProcessorConfiguration.class)
public class FileProcessorApplication implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(FileProcessorApplication.class);

    @Autowired
    private FileProcessorService fileProcessorService;
    @Autowired
    private FileProcessorConfiguration fileProcessorConfiguration;
    @Autowired
    private PersonProcessorInitializer personProcessorInitializer;
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FileProcessorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Started...");
        personProcessorInitializer.ChainProcessors();
        fileProcessorService.Process(fileProcessorConfiguration.getFilePath());
        log.info("Total males : " + FileProcessorState.getInstance().getTotalMales());
        log.info("Oldest person : " + FileProcessorState.getInstance().getOldest());
        log.info("Age difference : " + FileProcessorState.getInstance().getAgeDifference());
        log.info("Finished");
    }
}