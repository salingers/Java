package frank.java.chapter13.anno.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PermissionHandler implements InvocationHandler {

	private Object target;
	
	public PermissionHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Permission anno = method.getAnnotation(Permission.class);
		if (anno != null) {
			int mask = Context.INSTANCE.getCurrentPermission();
			if ( !((mask & anno.value()) == anno.value()) )
				throw new SecurityException("用户权限不足!");
		}
		return method.invoke(target, args);
	}

}
