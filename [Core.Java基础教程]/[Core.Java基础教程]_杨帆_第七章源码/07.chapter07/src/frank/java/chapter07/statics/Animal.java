package frank.java.chapter07.statics;

public class Animal {
	
	static { // 静态代码块
		System.out.println("Animal的静态代码块");
	}
	{ // 普通代码块
		System.out.println("Animal的普通代码块");
	}
	
	private String name;
	
	public Animal() {
		System.out.println("Animal的默认构造器");
	}
	
	public Animal(String name) {
		System.out.println("Animal的有参构造器");
	}

	public String getName() {
		return name;
	}

}
