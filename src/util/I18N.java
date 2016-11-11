package util;

import static java.lang.System.out;
import java.util.ResourceBundle;

public class I18N
{
	public static void main(String[] args)
	{
		ResourceBundle res = ResourceBundle.getBundle("messages");

		out.print(res.getString("cc.openhome.welcome") + "!");
		out.println(res.getString("cc.openhome.name") + "!");
	}
}
