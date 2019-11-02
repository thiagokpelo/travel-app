package dev.thiagokpelo.viagens.utils;

public class DateUtil {

    public static final String PLURAL_DAYS = " dias";
    public static final String SINGULAR_DAYS = " dia";

    public static String daysInTextFormat(int daysQnt) {

        return (daysQnt > 1)
                ? daysQnt + PLURAL_DAYS
                : daysQnt + SINGULAR_DAYS;
    }
}
