package com.travix.formatter;

import java.math.BigDecimal;

public class ValueFormatter
{
    public static final String DATE_TIME_ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'";

    public static double round(final double value)
    {
        final int scale = 2;
        final BigDecimal bd1 = new BigDecimal(value);
        final BigDecimal bd2 = bd1.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd2.doubleValue();
    }

    public static String getLetterIATACode(final String code)
    {
        if (code.length() <= 3)
            return code;

        return code.substring(0, 3);
    }
}