package org.example.processors;

import org.example.models.Person;
import org.example.state.FileProcessorState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class PersonAgeDifferenceProcessor extends PersonProcessor{
    private final Logger log = LoggerFactory.getLogger(PersonAgeDifferenceProcessor.class);
    private Date billDOB;
    private Date paulDOB;
    @Override
    protected void subProcess(Person person) {
        log.info("PersonAgeDifferenceProcessor");

        if(person.getName().startsWith("Bill"))
        {
            billDOB = person.getDOB();
            log.info("Bill DOB : " + billDOB.toString());
        }

        if(person.getName().startsWith("Paul"))
        {
            paulDOB = person.getDOB();
            log.info("Paul DOB : " + paulDOB.toString());
        }

        if(billDOB != null && paulDOB != null)
        {
            long diffInMillies = Math.abs(billDOB.getTime() - paulDOB.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            FileProcessorState.getInstance().setAgeDifference(diff);
        }
    }
}
