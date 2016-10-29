package frank.java.chapter13.clz;

import frank.java.chapter13.Human;

/**
 * 获得 Class 类实例的演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GetClassDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		// 方式一
		Class<Human> clz1 = Human.class;
		System.out.println(clz1);
		
		// 方式二
		Human instance = new Human();
		Class<Human> clz2 = (Class<Human>) instance.getClass();
		System.out.println(clz2);
		
		// 方式三
		Class<Human> clz3 = (Class<Human>) Class.forName("frank.java.chapter13.Human");
		System.out.println(clz3);
		
		System.out.println("三个Class实例是否相同:" + (clz1 == clz2 && clz2 == clz3));
	}

}
