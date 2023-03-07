package org.example.converters;

import org.example.configuration.FileProcessorConfiguration;
import org.example.enums.Gender;
import org.example.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StringToPersonConverter implements Converter<String, Person> {
    private final Logger log = LoggerFactory.getLogger(StringToPersonConverter.class);
    @Autowired
    private FileProcessorConfiguration _fileProcessorConfiguration;

    /*
    Returns person object rom comma separated string
     */
    @Override
    public Person convert(String source) {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(_fileProcessorConfiguration.getDateTimeFormat());

        List<String> lineFragments = Stream.of(source.split(_fileProcessorConfiguration.getFieldSeparator()))
                .collect(Collectors.toList());

        Person person = new Person();
        person.setName(lineFragments.get(0).trim());
        person.setGender(getGenderFor(lineFragments.get(1)));

        try
        {
            person.setDOB(dateTimeFormatter.parse(lineFragments.get(2)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    /*
        Returns gender for the input string
     */
    private Gender getGenderFor(String gender)
    {
        try
        {
            return Gender.valueOf(gender.trim().toUpperCase());
        }
        catch(Exception ex)
        {
            log.error("Unable to parse enum for string " + gender );
            return Gender.UNKNOWN;
        }
    }
}
