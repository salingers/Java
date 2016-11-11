package util;

import java.util.Locale;

public class LocaleList
{
	public static void main(String[] args)
	{
		Locale[] localeList = Locale.getAvailableLocales();

		for (int i = 0; i < localeList.length; i++)
		{
			// 列印出所支援的國家和語系
			System.out.println(localeList[i].getDisplayCountry() + "=" + localeList[i].getCountry());
			System.out.println(localeList[i].getDisplayLanguage() + "=" + localeList[i].getLanguage());
		}
	}
}
