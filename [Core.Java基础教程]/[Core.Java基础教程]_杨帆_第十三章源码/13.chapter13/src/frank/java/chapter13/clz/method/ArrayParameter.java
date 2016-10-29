package frank.java.chapter13.clz.method;

import java.lang.reflect.Method;

/**
 * 指定数组参数的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ArrayParameter {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class<ArrayParameter> clz = ArrayParameter.class;
		Method main = clz.getDeclaredMethod("main", String[].class);
		System.out.println(main);
		
		Method sum = clz.getDeclaredMethod("sum", int[].class);
		System.out.println(sum);
	}
	
	public static int sum(int...numbers) {
		int total = 0;
		for (int n : numbers)
			total += n;
		return total;
	}

}
