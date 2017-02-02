package com.travix.formatter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ValueFormatter
{
	public static double round(final double value) {
		final int scale = 2;
		final BigDecimal bd1 = new BigDecimal(value);
		final BigDecimal bd2 = bd1.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return bd2.doubleValue();
	}

	public static LocalDate getDateTimeISO8801(final String date) {
		final int year = Integer.valueOf(date.substring(6, 10)).intValue();
		final int month = Integer.valueOf(date.substring(0, 2)).intValue();
		final int day = Integer.valueOf(date.substring(3, 5)).intValue();
		return LocalDate.of(year, month, day);
	}
}