package frank.java.chapter13.clz.array;

import java.lang.reflect.Array;

/**
 * 通过反射创建数组实例的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class CreateArray {

	public static void main(String[] args) {
		// 创建数组
		int[] numbers = (int[]) Array.newInstance(int.class, 3);
		for (int i = 0; i < numbers.length;) {
			// 设置数组内容
			Array.set(numbers, i, ++i);
		}
		for (int i : numbers) {
			System.out.println(i);
		}
	}

}
