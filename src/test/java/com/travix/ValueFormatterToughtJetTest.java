package com.travix;

import org.junit.Assert;
import org.junit.Test;

import com.travix.formatter.ValueFormatterToughJet;

public class ValueFormatterToughtJetTest
{
    @Test
    public void validTest()
    {
        final int departureYear = 2010;
        final int departureMonth = 10;
        final int departureDay = 15;
        final String response = ValueFormatterToughJet.getDateTimeISO8801(departureDay, departureMonth, departureYear);
        Assert.assertEquals("2010-10-15T03:00Z", response);
    }

    @Test
    public void invalidTest()
    {
        final int departureDay = 00;
        final int departureMonth = 121;
        final int departureYear = 45;
        final String response = ValueFormatterToughJet.getDateTimeISO8801(departureDay, departureMonth, departureYear);
        Assert.assertEquals("0054-12-31T03:00Z", response);
    }
}