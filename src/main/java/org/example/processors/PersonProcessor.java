package org.example.processors;

import org.example.models.Person;

public abstract class PersonProcessor {
    protected PersonProcessor next;

    public void setNext(PersonProcessor personProcessor)
    {
        next = personProcessor;
    }

    protected abstract void subProcess(Person person);

    public void Process(Person person)
    {
        subProcess(person);

        if(next != null)
        {
            next.Process(person);
        }
    }
}
