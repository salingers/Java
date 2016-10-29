package frank.java.chapter07.inner;

/**
 * 成员内部类范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Outer {

	private String outerField = "outer";
	private String field = "outer";
	
	public class Inner {
		
		private String innerField = "inner";
		private String field = "inner";
		
		public void innerMethod() {
			System.out.println(outerField);
			System.out.println(this.field);
			System.out.println(Outer.this.field);
		}
	}
	
	public void outerMethod() {
		Inner inner = new Inner();
		System.out.println(inner.innerField);
	}

}
