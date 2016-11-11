package util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LocaleDate
{
	public static void main(String[] args)
	{
		Date now = new Date();
		Locale locale = Locale.JAPAN;

		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);

		System.out.println(df.format(now));
	}
}