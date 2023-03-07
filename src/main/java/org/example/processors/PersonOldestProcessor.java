package org.example.processors;

import org.example.models.Person;
import org.example.state.FileProcessorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonOldestProcessor extends PersonProcessor{
    private final Logger log = LoggerFactory.getLogger(PersonOldestProcessor.class);

    @Override
    protected void subProcess(Person person) {
        log.info("PersonOldestProcessor");

        if(FileProcessorState.getInstance().getOldest() == null ||
                FileProcessorState.getInstance().getOldest().getDOB() == null)
        {
            FileProcessorState.getInstance().setOldest(person);
        }
        else
        {
            var oldestPerson = FileProcessorState.getInstance().getOldest();
            if(person.getDOB().compareTo(oldestPerson.getDOB()) < 0)
            {
                FileProcessorState.getInstance().setOldest(person);
            }
        }
    }
}
