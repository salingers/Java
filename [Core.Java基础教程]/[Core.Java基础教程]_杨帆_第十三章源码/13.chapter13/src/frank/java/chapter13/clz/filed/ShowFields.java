package frank.java.chapter13.clz.filed;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import frank.java.chapter13.Human;

/**
 * 列出类属性的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ShowFields {

	public static void main(String[] args) {
		
		Class<Human> clz = Human.class;

		System.out.println("方式一");
		for (Field c : clz.getFields()) {
			System.out.println(c);
		}
		
		System.out.println("方式二");
		for (Field c : clz.getDeclaredFields()) {
			System.out.println(c);
		}
		
		System.out.println("列出全部属性");
		for (Field c : getAllFields(clz)) {
			System.out.println(c);
		}
	}
	
	public static List<Field> getAllFields(Class<?> clz) {
		List<Field> result = new ArrayList<Field>();
		if (clz != null) {
			result.addAll(getAllFields(clz.getSuperclass()));
			for (Field f : clz.getDeclaredFields()) {
				result.add(f);
			}
		}
		return result;
	}

}
