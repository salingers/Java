package frank.java.chapter07.inner;

/**
 * 局部内部类范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Part {

	private String outerField = "outer";
	private volatile String field = "outer";
	
	public void outerMethod(final String arg) {
		final String variable = "变量";
		class Inner {
			private String innerField = "inner";
			private String field = "inner";
			private void innerMethod() {
				System.out.println("属性测试");
				System.out.println(outerField);
				System.out.println(this.field);
				System.out.println(Part.this.field);
				System.out.println("参数");
				System.out.println(arg);
				System.out.println("变量");
				System.out.println(variable);
			}
		}
		Inner inner = new Inner();
		System.out.println(inner.innerField);
		inner.innerMethod();
	}

}
