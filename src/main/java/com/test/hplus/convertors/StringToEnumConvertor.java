package com.test.hplus.convertors;

import com.sun.tools.javac.jvm.Gen;
import com.test.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;

//This is a custom converter that converts a string into an Enum of type Gender
public class StringToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String s) {
        if(s.equals("Male")) {
            return Gender.MALE;
        }
        else if(s.equals("Female")) {
            return Gender.FEMALE;
        }
        else {
            return Gender.OTHER;
        }
    }
}
