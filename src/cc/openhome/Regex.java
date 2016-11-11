package cc.openhome;

import static java.lang.System.out;
import java.util.*;
import java.util.regex.*;

public class Regex
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		try
		{

			String regex = console.nextLine();
			
			String text = console.nextLine();
			print(match(regex, text));
		}
		catch (PatternSyntaxException ex)
		{
			out.println("閬�”蝷箏��炊");
			out.println(ex.getMessage());
		}
	}

	private static List<String> match(String regex, String text)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		List<String> matched = new ArrayList<>();
		while (matcher.find())
		{
			matched.add(String.format("敺揣撘� %d ���蝝Ｗ�� %d 銋��蝚血���� \"%s\"%n", matcher.start(), matcher.end(),
					matcher.group()));
		}
		return matched;
	}

	private static void print(List<String> matched)
	{
		if (matched.isEmpty())
		{
			out.println("�銝蝚血����");
		}
		else
		{
			matched.forEach(out::println);
		}
	}
}
