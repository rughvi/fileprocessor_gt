package org.example.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileProcessorService {
    private final Logger log = LoggerFactory.getLogger(FileProcessorService.class);

    public void Process(String filePath) throws IOException {
        if(filePath.isBlank())
        {
            throw new IOException("Provided file path is blank");
        }

        File file = new File(filePath);
        log.info("Processing file " + filePath);

        //Reads from file one line at a time.
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try
        {
            while (it.hasNext())
            {
                String line = it.nextLine();
                //Now process each line.
            }
        }
        catch(Exception ex)
        {
            log.error("Error occured while processing the file");
            throw  ex;
        }
        finally
        {
            log.info("Closing file ");
            LineIterator.closeQuietly(it);
        }
        log.info("Finished processing file");
    }
}
