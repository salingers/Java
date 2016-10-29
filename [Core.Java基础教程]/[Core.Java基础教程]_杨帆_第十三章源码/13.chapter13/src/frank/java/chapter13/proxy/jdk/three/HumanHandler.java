package frank.java.chapter13.proxy.jdk.three;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanHandler implements InvocationHandler {
	
	private String name;
	
	public HumanHandler(String name) {
		this.name = name;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getDeclaringClass().equals(Object.class))
			method.invoke(this, args);
		System.out.println(name + " 在做某事!");
		return null;
	}

}
