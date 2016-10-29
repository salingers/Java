package frank.java.chapter13.proxy.jdk.two;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {

	public static void main(String[] args) {
		Student s = (Student) getStudent("陈文才");
		s.study();
		s.fun();
	}
	
	public static Student getStudent(String name) {
		InvocationHandler handler = new GoodStudentHandler(new NormalStudent(name));
		return (Student) Proxy.newProxyInstance(Demo.class.getClassLoader(), 
				new Class<?>[]{Student.class}, 
				handler);
	}

}
