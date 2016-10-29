package frank.java.chapter13.clz;

/**
 * 基本数据类型与对应的 Class 的演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class PrimitiveDemo {

	public static void main(String[] args) {
		Class<?> clz1 = Integer.class;
		Class<?> clz2 = int.class;
		Class<?> clz3 = Integer.TYPE;
		
		System.out.println("Integer.class == int.class : " + (clz1 == clz2) );
		System.out.println("Integer.TYPE == int.class : " + (clz3 == clz2) );
		
		// 测试是个 Class 是否基本数据类型
		System.out.println(clz1.isPrimitive());
		System.out.println(clz2.isPrimitive());
	}

}
