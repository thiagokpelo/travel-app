package dev.thiagokpelo.viagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static final String LANGUAGE = "pt";
    public static final String COUNTRY = "br";
    public static final String TARGET = "R$";
    public static final String REPLACEMENT = "R$ ";

    public static String brazilFormat(BigDecimal value) {
        NumberFormat formatBrazil = DecimalFormat
                .getCurrencyInstance(new Locale(LANGUAGE, COUNTRY));
        return formatBrazil.format(value).replace(TARGET, REPLACEMENT);
    }
}

