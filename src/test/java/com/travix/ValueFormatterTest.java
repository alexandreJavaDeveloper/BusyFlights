package com.travix;

import org.junit.Assert;
import org.junit.Test;

import com.travix.formatter.ValueFormatter;

public class ValueFormatterTest
{
    @Test
    public void validTest()
    {
        Assert.assertEquals(new Double(10.10), new Double(ValueFormatter.round(10.1010)));

        String code = "LHR";
        String letterIATACode = ValueFormatter.getLetterIATACode(code);
        Assert.assertEquals("LHR", letterIATACode);

        code = "LHRa2";
        letterIATACode = ValueFormatter.getLetterIATACode(code);
        Assert.assertEquals("LHR", letterIATACode);

        code = "LH";
        letterIATACode = ValueFormatter.getLetterIATACode(code);
        Assert.assertEquals("LH", letterIATACode);
    }
}