package frank.java.chapter07.inner;

/**
 * 成员内部类范例测试
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class OuterTest {

	public static void main(String[] args) {
		System.out.println("测试外部类");
		Outer outer = new Outer();
		outer.outerMethod();

		System.out.println("测试内部类");
		Outer.Inner inner = outer.new Inner();
		inner.innerMethod();
	}

}
