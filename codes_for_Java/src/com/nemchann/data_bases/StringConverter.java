package com.nemchann.data_bases;

public class StringConverter implements TypeConverter<String>{
    @Override
    public String convert(String value) {
        return value;
    }

    @Override
    public Class<String> getTargetClass() {
        return String.class;
    }
}
