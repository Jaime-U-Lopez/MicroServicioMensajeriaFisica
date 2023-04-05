package com.mensajeria.ServicioMensajeria.Util;

import java.util.Date;
import java.util.function.Consumer;

public class UpdateFieldUtil {


    public UpdateFieldUtil() {

    }

    public static void updateFieldNullEmptyString(String value, Consumer<String> setter) {
        if (value != null && !value.isEmpty()) {
            setter.accept(value);
        }
    }

    public static void updateFieldLong(Long value, Consumer<Long> setter) {
        if (value != 0 ) {
            setter.accept(value);
        }
    }


    public static void updateFieldInteger(Integer value, Consumer<Integer> setter) {
        if (value != 0 ) {
            setter.accept(value);
        }
    }

    public static void updateFieldDate(Date value, Consumer<Date> setter) {
        if (value != null ) {
            setter.accept(value);
        }
    }

    public static void updateFieldDouble(Double value, Consumer<Double> setter) {
        if (value != null ) {
            setter.accept(value);
        }
    }



}
