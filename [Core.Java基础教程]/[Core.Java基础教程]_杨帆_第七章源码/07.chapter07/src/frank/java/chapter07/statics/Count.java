package frank.java.chapter07.statics;

/**
 * 类属性 / 类方法范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Count {
	// 这是一个类属性
	private static int count = 0;
	// 这是一个对象/实例的属性
	private int serialNumber;
	
	public Count() {
		count++;
		serialNumber = count;
	}

	public int getId() {
		return serialNumber;
	}

	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		// 类属性使用范例
		Count c1 = new Count();
		Count c2 = new Count();
		
		System.out.println("C1:" + c1.getId());
		System.out.println("C2:" + c2.getId());		
	}
}
