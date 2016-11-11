package util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFo
{
	public static void main(String args[])
	{
		ResourceBundle myResources = ResourceBundle.getBundle("NewResourcesFile", Locale.CHINA);

		String message = myResources.getString("msg");
		String name = "±i¤T ";
		String hi = "¨þ¨þ¡I";
		Object[] fm =
		{ name, hi };

		System.out.println(MessageFormat.format(message, fm));
	}
}
