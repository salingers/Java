package frank.java.chapter13.clz.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import frank.java.chapter13.Human;

/**
 * 通过反射构建对象实例的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Demo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		
		Class<Human> clz = Human.class;
		
		// 使用无参/默认构造器创建对象实例
		Human instance = clz.newInstance();
		System.out.println(instance);

		// 调用公开构造器创建对象实例
		Constructor<Human> con1 = clz.getConstructor(String.class, int.class);
		instance = con1.newInstance("Frank", 32);
		System.out.println(instance);
		
		// 使用私有构造器创建对象实例
		Constructor<Human> con2 = clz.getDeclaredConstructor(int.class);
		con2.setAccessible(true);
		instance = con2.newInstance(32);
		System.out.println(instance);
	}

}
