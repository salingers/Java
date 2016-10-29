package frank.java.chapter07.statics;

/**
 * 类方法使用范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
@SuppressWarnings("unused")
public class MethodDemo {

	public static void main(String[] args) {
		System.out.println("Count : " + Count.getCount());
		Count c = new Count();
		System.out.println("Count : " + Count.getCount());
	}

}
