package frank.java.chapter07.singleton;

/**
 * 饿汉式单例范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Greedy {
	
	private final static Greedy me = new Greedy();
	
	private Greedy() {
	}

	public static Greedy getInstance() {
		return me;
	}
}
