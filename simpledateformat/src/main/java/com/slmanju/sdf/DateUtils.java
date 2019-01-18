package com.slmanju.sdf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateUtils() {}

    public static Date parse(String target) {
        try {
            return SIMPLE_DATE_FORMAT.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(Date target) {
        return SIMPLE_DATE_FORMAT.format(target);
    }

}
