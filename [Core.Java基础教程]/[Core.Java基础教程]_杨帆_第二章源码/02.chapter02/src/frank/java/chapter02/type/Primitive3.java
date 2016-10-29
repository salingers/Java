package frank.java.chapter02.type;

//Java5 后的新特性：静态导入
import static java.lang.System.out;

/**
 * 基本数据类型 - 整型
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Primitive3 {
	
	private byte byte1;
	private short short1;
	private int int1;
	private long long1;
	
	public static void main(String[] args) {
		Primitive3 type = new Primitive3();
		
		// byte 长度为1个字节(byte) ps:1 byte = 8 bit
		byte byte2 = 127;
		byte byte3 = 0177;
		byte byte4 = 0x7F;
		// short 长度为2个字节
		short short2 = 32767;
		short short3 = 077777;
		short short4 = 0x7FFF;
		// int 长度为4个字节
		// 赋值的语句的另外一种写法，不过该写法并不推荐使用
		int int2 = 255, int3 = 0377, int4 = 0xFF;
		// long 长度为8个字节
		long long2 = 255, long3 = 0377, long4 = 0xFF;
		long long5 = 10000000000L; // 当数值超出 int 值的表示返回时，要在结尾加L
		
		out.println("byte");
		out.println("1:" + type.byte1 + "\t2:" + byte2 + "\t3:" + byte3 + "\t4:" + byte4);
		out.println("short");
		out.println("1:" + type.short1 + "\t2:" + short2 + "\t3:" + short3 + "\t4:" + short4);
		out.println("int");
		out.println("1:" + type.int1 + "\t2:" + int2 + "\t3:" + int3 + "\t4:" + int4);
		out.println("long");
		out.println("1:" + type.long1 + "\t2:" + long2 + "\t3:" + long3 + "\t4:" + long4 + "\t5:" + long5);
		/*
		 * 思考并测试，在赋值时值超过了类型的最大与最小表示范围会得到怎样的结果
		 */
	}
}
