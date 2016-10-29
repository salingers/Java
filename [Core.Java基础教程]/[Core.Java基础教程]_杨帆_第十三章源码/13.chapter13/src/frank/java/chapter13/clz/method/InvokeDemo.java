package frank.java.chapter13.clz.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import frank.java.chapter13.Human;

/**
 * 方法调用演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InvokeDemo {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Human instance = new Human("Frank", 32);
		Class<Human> clz = Human.class;
		
		// 操作get方法
		Method getMethod = clz.getMethod("getName");
		String name = (String) getMethod.invoke(instance);
		System.out.println(name);
		
		// 操作set方法
		Method setMethod = clz.getMethod("setName", String.class);
		setMethod.invoke(instance, "法兰克");
		System.out.println(instance);
		
		// 操作非公开方法
		setMethod = clz.getSuperclass().getDeclaredMethod("setAge", int.class);
		System.out.println(setMethod.isAccessible());
		setMethod.setAccessible(true);
		setMethod.invoke(instance, 20);
		System.out.println(instance);
	}

}
