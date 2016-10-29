package frank.java.chapter07.inner.statics;

/**
 * 静态内部类范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Outer {
	
	private static String outerStaticField = "outer static";
	private String outerField = "outer";
	
	static class Inner {
		
		private static String innerStaticField = "inner static";
		private String innerField = "inner";
		
		public static void innerMethodOne() {
			System.out.println(outerStaticField);
		}
		
		public void innerMethodTwo() {
			Outer outer = new Outer();
			System.out.println(outer.outerField);
		}
	}

	public static void outerMethodOne() {
		System.out.println(Inner.innerStaticField);
	}
	
	public void outerMethodTwo() {
		Inner inner = new Inner();
		System.out.println(inner.innerField);
	}
}
