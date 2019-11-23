package dev.thiagokpelo.viagens.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static final String PLURAL_DAYS = " dias";
    public static final String SINGULAR_DAYS = " dia";

    public static String daysInTextFormat(int daysQnt) {

        return (daysQnt > 1)
                ? daysQnt + PLURAL_DAYS
                : daysQnt + SINGULAR_DAYS;
    }

    public static String periodToString(int days) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, days);

        SimpleDateFormat dateBrazilFormat = new SimpleDateFormat("dd/MM");
        String startDateFormatted = dateBrazilFormat.format(startDate.getTime());
        String endDateFormatted = dateBrazilFormat.format(endDate.getTime());

        return startDateFormatted
                + " - " + endDateFormatted
                + " de " + endDate.get(Calendar.YEAR);
    }
}
