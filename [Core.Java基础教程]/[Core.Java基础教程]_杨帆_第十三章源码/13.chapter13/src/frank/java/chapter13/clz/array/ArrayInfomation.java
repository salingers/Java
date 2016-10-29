package frank.java.chapter13.clz.array;

import java.lang.reflect.Array;

/**
 * 通过反射获取数组信息的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ArrayInfomation {

	public static void main(String[] args) {
		Object obj = getArray();
		Class<?> clz = obj.getClass();
		System.out.println(clz.getName());
		
		System.out.println("这个对象是数组吗：" + clz.isArray());
		System.out.println("元素的类型是什么:" + clz.getComponentType());

		// Array 工具类的使用
		int length = Array.getLength(obj); // 获取数组长度
		for (int i = 0; i < length; i++) { // 迭代数组内容
			System.out.println(Array.get(obj, i));
		}
	}
	
	public static Object getArray() {
		return new String[]{"one", "two", "three"};
	}

}
