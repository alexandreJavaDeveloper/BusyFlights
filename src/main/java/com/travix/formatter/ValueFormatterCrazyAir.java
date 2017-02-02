package com.travix.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ValueFormatterCrazyAir
{
    private static final String DATE_TIME_CRAZY_AIR_FORMAT = "MM-dd-yyyy HH:mm:ss";

    public static String getDateTimeISO8801(final String inputDateAsString)
    {
        try
        {
            final DateFormat iso8601DateFormatter = new SimpleDateFormat(ValueFormatter.DATE_TIME_ISO8601_FORMAT, Locale.ENGLISH);
            iso8601DateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));

            final DateFormat inputDateFormatter = new SimpleDateFormat(ValueFormatterCrazyAir.DATE_TIME_CRAZY_AIR_FORMAT, Locale.ENGLISH);
            final Date inputDate = inputDateFormatter.parse(inputDateAsString);

            return iso8601DateFormatter.format(inputDate);
        }
        catch (final ParseException e)
        {
            e.printStackTrace(); // "log4j"
            return "";
        }
    }
}