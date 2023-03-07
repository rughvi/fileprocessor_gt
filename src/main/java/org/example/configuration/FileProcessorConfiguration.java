package org.example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fileprocessor")
@Data
public class FileProcessorConfiguration {
    private String FilePath;
    private String FieldSeparator;
    private String DateTimeFormat;
}
