package frank.java.chapter13.proxy.jdk.three;

import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) {
		Human man = getHuman("陈文才");
		man.doSomething();
	}
	
	public static Human getHuman(String name) {
		return (Human) Proxy.newProxyInstance(Demo.class.getClassLoader(), 
				new Class<?>[]{Human.class}, new HumanHandler(name));
	}

}
