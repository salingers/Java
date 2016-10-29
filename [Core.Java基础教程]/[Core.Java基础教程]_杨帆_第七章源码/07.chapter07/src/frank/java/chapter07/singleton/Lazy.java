package frank.java.chapter07.singleton;

/**
 * 懒汉式单例范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Lazy {
	
	private Lazy() {
		// 通常懒汉式单例的初始化都会有比较多的东西
	}
	
	// volatile 关键字指示一个字段可以由多个同时执行的线程修改。
	// 声明为 volatile 的字段不受编译器优化（假定由单个线程访问）的限制。
	// 这样可以确保该字段在任何时间呈现的都是最新的值。
	private volatile static Lazy me;
	
	public static Lazy getInstance() {
		if (me == null)
			synchronized (Lazy.class) {
				if (me == null)
					me = new Lazy();
			}
		return me;
	}
}
