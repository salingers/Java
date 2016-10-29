package frank.java.chapter07.finals;

import frank.java.chapter07.statics.User;

/**
 * final 范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
@SuppressWarnings("unused")
public class FinalDemo {

	public static void main(String[] args) {
		// final 变量范例
		final int x = 10;
		// x = 20; // 多次赋值是不被允许的
		final User user;
		// 空 final 变量可被赋值一次
		user = new User();
		
		// final 属性的定义与赋值范例
		Field field = new Field();
		System.out.println(field.getX());
		System.out.println(field.getUserOne());
		System.out.println(field.getUserTwo());
	}

}

class Parent {
	public final void doSomething() {
		System.out.println("不可被覆盖的方法！");
	}
}

class Child extends Parent {
	/*
	public void doSomething() {
		System.out.println("无法被覆盖的方法！");
	}
	*/
}