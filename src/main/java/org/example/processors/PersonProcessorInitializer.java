package org.example.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonProcessorInitializer {
    private PersonProcessor rootProcessor;
    @Autowired
    private PersonTotalMalesProcessor personTotalMalesProcessor;
    @Autowired
    private PersonOldestProcessor personOldestProcessor;
    @Autowired
    private PersonAgeDifferenceProcessor personAgeDifferenceProcessor;

    public void ChainProcessors()
    {
        personOldestProcessor.setNext(personAgeDifferenceProcessor);
        personTotalMalesProcessor.setNext(personOldestProcessor);
        rootProcessor = personTotalMalesProcessor;
    }

    public PersonProcessor GetRootProcessor()
    {
        return rootProcessor;
    }
}
