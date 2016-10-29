
/**
 * 懒汉式单例模式范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Singletone {

	private static volatile Singletone me;

	private Singletone() {
	}

	public static Singletone getInstance() {
		if (me == null)
			synchronized (Singletone.class) {
				if (me == null)
					me = new Singletone();
			}
		return me;
	}
	
}
