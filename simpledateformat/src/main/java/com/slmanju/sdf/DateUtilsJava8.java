package com.slmanju.sdf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtilsJava8 {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private DateUtilsJava8() {}

    public static LocalDate parse(String target) {
        return LocalDate.parse(target, DATE_TIME_FORMATTER);
    }

    public static String format(LocalDate target) {
        return target.format(DATE_TIME_FORMATTER);
    }

}
