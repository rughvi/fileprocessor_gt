package org.example;

import org.example.services.FileProcessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class FileProcessorServiceTests {

    @InjectMocks
    private FileProcessorService _fileProcessorService;

    @Test
    public void givenABlankFilePathToProcessThenExceptionIsRaised() {
        assertThrows(IOException.class,
                ()-> _fileProcessorService.Process(""));
    }

    @Test
    public void givenAFilePathToProcessThenProcessSuccess() throws IOException {
        String filePath = "../AddressBook.csv";
        _fileProcessorService.Process(filePath);
    }
}
