package frank.java.chapter13.proxy.jdk.one;

import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) {
		IUserManager manager = getProxy();
		manager.createUser("frank", "123456", true, 32);
	}
	
	private static IUserManager getProxy() {
		return (IUserManager) Proxy.newProxyInstance(Demo.class.getClassLoader(), 
				new Class<?>[]{IUserManager.class}, 
				new LogHandler(new UserManager()));
	}

}
