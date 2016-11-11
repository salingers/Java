package util.logging;

import java.time.Instant;
import java.util.logging.*;

public class FormatterDemo
{
	public static void main(String[] args)
	{

		Logger logger = Logger.getLogger(FormatterDemo.class.getName());
		ConsoleHandler handler = new ConsoleHandler();

		logger.setLevel(Level.CONFIG);

		handler.setLevel(Level.CONFIG);
		handler.setFormatter(new Formatter()
		{
			@Override
			public String format(LogRecord record)
			{
				return "�隤� " + record.getSourceClassName() + "." + record.getSourceMethodName() + "\n"
						+ "\t撅斤�t: " + record.getLevel() + "\n" + "\t閮\t: " + record.getMessage() + "\n"
						+ "\t���t: " + Instant.ofEpochMilli(record.getMillis()) + "\n";
			}
		});
		logger.addHandler(handler);
		logger.config("�閮� Formatter 閮");
	}
}
