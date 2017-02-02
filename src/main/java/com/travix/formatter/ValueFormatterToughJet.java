package com.travix.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ValueFormatterToughJet
{
    private static final String DATE_TIME_TOUGH_JET_FORMAT = "MM-dd-yyyy";

    public static String getDateTimeISO8801(final int departureDay, final int departureMonth, final int departureYear)
    {
        final String inputDateAsString = departureMonth + "-" + departureDay + "-" + departureYear;
        final DateFormat iso8601DateFormatter = new SimpleDateFormat(ValueFormatter.DATE_TIME_ISO8601_FORMAT, Locale.ENGLISH);
        iso8601DateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        final DateFormat inputDateFormatter = new SimpleDateFormat(ValueFormatterToughJet.DATE_TIME_TOUGH_JET_FORMAT, Locale.ENGLISH);
        Date inputDate;
        try
        {
            inputDate = inputDateFormatter.parse(inputDateAsString);
        }
        catch (final ParseException e)
        {
            // was make the Catch because won't be throw ParseException when receiving int values to make the parse as String
            e.printStackTrace(); // Log4j
            return "";
        }

        return iso8601DateFormatter.format(inputDate);
    }
}