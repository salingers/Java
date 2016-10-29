package frank.java.chapter02.type;

/**
 * 基本数据类型 - 布尔型
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Primitive1 {
	
	// 原始数据类型不指定值时，都会有默认值，需要注意
	/** 内部属性 */
	public boolean boolean1;
	
	public static void main(String[] args) {
		Primitive1 type = new Primitive1();
		
		// boolean boolean1;
		boolean boolean2 = true;
		boolean boolean3 = 1 < 0;
		
		// System.out.println("boolean1:" + boolean1);
		System.out.println("boolean1:" + type.boolean1);
		System.out.println("boolean2:" + boolean2);
		System.out.println("boolean3:" + boolean3);
	}

}
