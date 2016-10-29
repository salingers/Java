package frank.java.chapter07.enums;

/**
 * 旧枚举使用范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class OldEnumDemo {

	public static void main(String[] args) {
		char grade = getGrade(83);
		
		switch (grade) {
		case 'A':
			System.out.println("优秀");
			break;
		case 'B':
			System.out.println("良好");
			break;
		case 'C':
			System.out.println("一般");
			break;
		case 'D':
			System.out.println("差");
			break;
		default:
			System.out.println("其它");
			break;
		}
	}
	
	public static char getGrade(int number) {
		if (number >= 85)
			return IGrade.EXCELLENT;
		if (number >= 75)
			return IGrade.GOOD;
		if (number >= 60)
			return IGrade.PASS;
		return IGrade.FAILURE;
	}

}
