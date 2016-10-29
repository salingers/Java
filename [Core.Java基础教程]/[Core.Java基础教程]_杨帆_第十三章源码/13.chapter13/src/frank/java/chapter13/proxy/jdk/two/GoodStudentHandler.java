package frank.java.chapter13.proxy.jdk.two;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GoodStudentHandler implements InvocationHandler {
	
	private static Method study;
	private static Method fun;
	private NormalStudent target;
	
	static {
		Class<Student> clz = Student.class;
		try {
			study = clz.getMethod("study");
			fun = clz.getMethod("fun");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public GoodStudentHandler(NormalStudent student) {
		target = student;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.equals(fun))
			return study.invoke(target, args);
		return method.invoke(target, args);
	}

}
