package cc.openhome;

import static java.lang.System.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.MinguoDate;
import static java.time.format.DateTimeFormatter.ofPattern;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import static java.util.Calendar.*;

public class Minguo
{
	public static void main(String[] args)
	{
		MinguoDate minguoDate = MinguoDate.now();
		showTitle(minguoDate);
		showDate(minguoDate);
	}

	private static void showTitle(MinguoDate minguoDate)
	{
		out.printf("%n%s%n%n", minguoDate.format(ofPattern("瘞�� yyy 撟� MM ��� dd � EE")));
		String[] weekDays =
		{ "�", "銝�", "鈭�", "銝�", "���", "鈭�", "�" };
		for (String weekDay : weekDays)
		{
			out.printf("%s ", weekDay);
		}
		out.println();
	}

	private static void showDate(Calendar calendar)
	{
		Calendar cal = (Calendar) calendar.clone();
		// 隞予����洵撟曉予
		int dayOfMonth = cal.get(DAY_OF_MONTH);
		// 撠��身����洵銝�憭�
		cal.add(DAY_OF_MONTH, -dayOfMonth + 1);
		// ���������洵撟曉予
		int dayOfWeek = cal.get(DAY_OF_WEEK);
		// 憿舐內����膩
		out.printf("%" + (2 * (dayOfWeek + 1)) + "s", "");
		for (int i = 1; i <= cal.getMaximum(DAY_OF_MONTH); i++, dayOfWeek++)
		{
			out.printf("%2d ", i);
			if ((dayOfWeek % 7) == 0)
			{
				out.println();
			}
		}
	}

	private static void showDate(MinguoDate minguoDate)
	{
		// 隞予����洵撟曉予
		int dayOfMonth = minguoDate.get(ChronoField.DAY_OF_MONTH);
		// �����洵銝�憭抬������嗾
		int dayOfWeek = minguoDate.plus(-dayOfMonth + 1, ChronoUnit.DAYS).get(ChronoField.DAY_OF_WEEK);
		// dayOfWeek ��靘�����
		dayOfWeek++;
		out.printf("%" + (2 * (dayOfWeek + 1)) + "s", "");
		for (int i = 1; i <= minguoDate.lengthOfMonth(); i++, dayOfWeek++)
		{
			out.printf("%2d ", i);
			if ((dayOfWeek % 7) == 0)
			{
				out.println();
			}
		}
	}
}
