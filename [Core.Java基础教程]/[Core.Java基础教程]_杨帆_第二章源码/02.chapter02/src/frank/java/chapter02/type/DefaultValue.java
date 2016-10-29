package frank.java.chapter02.type;

/**
 * 默认初始化值演示
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class DefaultValue {
	
	private boolean booleanValue;
	private byte byteValue;
	private short shortValue;
	private int intValue;
	private long longValue;
	private float floatValue;
	private double doubleValue;
	private char charValue;
	private Object objectValue;

	public static void main(String[] args) {
		DefaultValue value = new DefaultValue();
		System.out.println("boolean:" + value.booleanValue);
		System.out.println("byte:" + value.byteValue);
		System.out.println("short:" + value.shortValue);
		System.out.println("int:" + value.intValue);
		System.out.println("long:" + value.longValue);
		System.out.println("float:" + value.floatValue);
		System.out.println("double:" + value.doubleValue);
		System.out.println("char:" + value.charValue);
		System.out.println("object:" + value.objectValue);
	}

}
