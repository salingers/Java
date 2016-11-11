package time.chrono;

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
		out.printf("%n%s%n%n", minguoDate.format(ofPattern("��嚙踝蕭 yyy ��蕭 MM 嚙踝蕭嚙� dd 嚙踐�� EE")));
		String[] weekDays =
		{ "嚙踐��", "��蕭", "�嚙�", "��蕭", "嚙踝蕭嚙�", "�嚙�", "嚙踝" };
		for (String weekDay : weekDays)
		{
			out.printf("%s ", weekDay);
		}
		out.println();
	}

	private static void showDate(Calendar calendar)
	{
		Calendar cal = (Calendar) calendar.clone();
		// ���鈭蕭謢�嚙踐秧嚙踝蕭��斯�����
		int dayOfMonth = cal.get(DAY_OF_MONTH);
		// ��嚙踝�蕭��澈嚙踐冪嚙踐秧嚙踝蕭��斯��蕭�嚙�
		cal.add(DAY_OF_MONTH, -dayOfMonth + 1);
		// 嚙踐�蕭嚙踝��蕭謓哨蕭謢�嚙踝蕭賹蕭賹蕭��斯�����
		int dayOfWeek = cal.get(DAY_OF_WEEK);
		// ���嚙踝蕭賹蕭賹蕭��
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
		// ���鈭蕭謢�嚙踐秧嚙踝蕭��斯�����
		int dayOfMonth = minguoDate.get(ChronoField.DAY_OF_MONTH);
		// 嚙踝蕭謘潘蕭謅秧嚙踝蕭��斯��蕭��嚙踝嚙踝�蕭謅嚙踝蕭賹蕭賹
		int dayOfWeek = minguoDate.plus(-dayOfMonth + 1, ChronoUnit.DAYS).get(ChronoField.DAY_OF_WEEK);
		// dayOfWeek 嚙踐�嚙踐���蕭��蕭���蕭嚙踝蕭
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
