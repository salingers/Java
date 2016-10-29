package frank.java.chapter13.proxy.jdk.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {
	
	private Object target;
	
	public LogHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Date start = new Date();
		Object result = method.invoke(target, args);
		Date end = new Date();
		System.out.print(method);
		System.out.println(" 的执行时间为:" + (end.getTime() - start.getTime()));
		return result;
	}

}
