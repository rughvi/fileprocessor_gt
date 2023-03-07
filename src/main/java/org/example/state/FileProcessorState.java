package org.example.state;

import lombok.Getter;
import lombok.Setter;
import org.example.models.Person;

@Getter
@Setter
public class FileProcessorState {
    private static FileProcessorState instance;
    private Integer totalMales;
    private long ageDifference;
    private Person oldest;

    private FileProcessorState()
    {

    }

    public static FileProcessorState getInstance()
    {
        if(instance == null)
        {
            instance = new FileProcessorState();
        }

        return instance;
    }
}
