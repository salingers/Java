package net;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceDemo
{
	public static void main(String[] args)
	{
		Locale locale = new Locale("zh", "CN");
		ResourceBundle myResources = ResourceBundle.getBundle("ResourcesFile", locale);

		String value = myResources.getString("hello");
		System.out.println("hello-" + value);
		value = myResources.getString("love");
		System.out.println("love-" + value);
	}
}
