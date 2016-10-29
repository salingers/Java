package frank.java.chapter07.statics;

public class Cat extends Animal {

	static {
		System.out.println("Cat的静态代码块");
	}
	{
		System.out.println("Cat的普通代码块");
	}

	public Cat() {
		super();
		System.out.println("Cat的默认构造器");
	}

	public Cat(String name) {
		super(name);
		// 思考下面语句和上面语句的区别
		// this();
		// super();
		System.out.println("Cat的有参构造器");
	}
}