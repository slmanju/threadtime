package com.slmanju.sdf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtilsThreadLocal {

    public static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private DateUtilsThreadLocal() {}

    public static Date parse(String target) {
        try {
            return SIMPLE_DATE_FORMAT.get().parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String format(Date target) {
        return SIMPLE_DATE_FORMAT.get().format(target);
    }

}
