package time;

import java.time.*;
import java.util.Scanner;
import static java.lang.System.out;

public class HowOld2
{
	public static void main(String[] args)
	{
		out.print("頛詨���僑��嚗yyy-mm-dd嚗��");
		LocalDate birth = LocalDate.parse(new Scanner(System.in).nextLine());
		LocalDate now = LocalDate.now();
		Period period = Period.between(birth, now);
		out.printf("雿暑鈭� %d 撟� %d ��� %d �%n", period.getYears(), period.getMonths(), period.getDays());
	}
}
