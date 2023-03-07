package org.example.processors;

import org.example.enums.Gender;
import org.example.models.Person;
import org.example.state.FileProcessorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonTotalMalesProcessor extends PersonProcessor{
    private final Logger log = LoggerFactory.getLogger(PersonTotalMalesProcessor.class);
    @Override
    protected void subProcess(Person person) {
        log.info("PersonTotalMalesProcessor");

        if( person.getGender().equals(Gender.MALE))
        {
            var totalMales = FileProcessorState.getInstance().getTotalMales();
            totalMales = (totalMales == null) ? 1 : totalMales + 1;
            FileProcessorState.getInstance().setTotalMales(totalMales);
        }
    }
}
