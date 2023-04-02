package com.mensajeria.ServicioMensajeria.Util;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    private static final String YYYYMMDD_FORMAT = "yyyyMMdd";

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDateYYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_FORMAT);
        return sdf.format(date);
    }
}
