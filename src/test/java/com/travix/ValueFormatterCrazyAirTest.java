package com.travix;

import org.junit.Assert;
import org.junit.Test;

import com.travix.formatter.ValueFormatterCrazyAir;

public class ValueFormatterCrazyAirTest
{
    @Test
    public void validTest()
    {
        final String inputDateAsString = "10-15-2010 10:15:30";
        final String response = ValueFormatterCrazyAir.getDateTimeISO8801(inputDateAsString);
        Assert.assertEquals("2010-10-15T13:15Z", response);
    }

    @Test
    public void invalidTest()
    {
        final String inputDateAsString = "45646-10-10";
        final String response = ValueFormatterCrazyAir.getDateTimeISO8801(inputDateAsString);
        Assert.assertTrue(response.isEmpty());
    }
}