package frank.java.chapter13.clz;

import frank.java.chapter13.Alive;
import frank.java.chapter13.Human;

/**
 * Class 实例判别继承关系的演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InheritDemo {

	public static void main(String[] args) {
		
		Class<Human> clz = Human.class;
		
		// 获得父类型
		Class<?> parent = clz.getSuperclass();
		System.out.println(parent);
		
		System.out.println("------华丽的分割线------");
		
		// 获得类上实现的接口
		Class<?>[] infs = parent.getInterfaces();
		for (Class<?> inf : infs) {
			System.out.println(inf);
		}

		System.out.println("------华丽的分割线------");
		
		// 检查一个类是否某个类的子类或者某个接口的实现
		// 类实例用 instanceof, 类用 isAssignableFrom 方法
		System.out.println(parent.isAssignableFrom(clz));
		System.out.println(Alive.class.isAssignableFrom(clz));
	}

}
