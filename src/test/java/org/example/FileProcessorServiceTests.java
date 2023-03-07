package org.example;

import org.example.configuration.FileProcessorConfiguration;
import org.example.converters.StringToPersonConverter;
import org.example.processors.PersonProcessorInitializer;
import org.example.services.FileProcessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileProcessorServiceTests {

    @Mock
    private FileProcessorConfiguration fileProcessorConfiguration;
    @Mock
    private PersonProcessorInitializer personProcessorInitializer;
    @InjectMocks
    private StringToPersonConverter stringToPersonConverter = Mockito.spy(new StringToPersonConverter());
    @InjectMocks
    private FileProcessorService _fileProcessorService;

    @Test
    public void givenABlankFilePathToProcessThenExceptionIsRaised() {
        assertThrows(IOException.class,
                ()-> _fileProcessorService.Process(""));
    }

    @Test
    public void givenAFilePathToProcessThenProcessSuccess() throws IOException {
        when(fileProcessorConfiguration.getDateTimeFormat()).thenReturn("dd/MM/yy");
        when(fileProcessorConfiguration.getFieldSeparator()).thenReturn(",");
        String filePath = "../AddressBook.csv";
        _fileProcessorService.Process(filePath);

        verify(stringToPersonConverter, times(5)).convert(anyString());
    }
}
