package org.example.models;

import lombok.Data;
import org.example.enums.Gender;

import java.util.Date;

@Data
public class Person {
    private String Name;
    private Gender Gender;
    private Date DOB;
}
