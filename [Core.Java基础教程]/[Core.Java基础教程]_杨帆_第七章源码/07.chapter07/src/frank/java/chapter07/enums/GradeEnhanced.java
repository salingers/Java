package frank.java.chapter07.enums;

/**
 * 增强型枚举类设计范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public enum GradeEnhanced {
	
	A(100, 85),
	B(85, 70),
	C(70, 60),
	D(60, 0);

	private int max;
	private int min;
	
	private GradeEnhanced(int max, int min) {
		this.max = max;
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}
	
	public static GradeEnhanced valueOf(int grade) {
		if (grade < 0)
			throw new IllegalArgumentException("grade must >= 0");
		if (grade >= A.getMin())
			return A;
		if (grade >= B.getMin())
			return B;
		if (grade >= C.getMin())
			return C;
		return D;
	}
}
