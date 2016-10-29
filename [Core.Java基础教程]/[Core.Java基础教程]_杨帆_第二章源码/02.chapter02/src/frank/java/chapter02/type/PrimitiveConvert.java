package frank.java.chapter02.type;

/**
 * 基本数据类转换分类2种：自动、强制 
 * byte > short > int > long > float > double
 * char > int
 * @author Frank
 */
@SuppressWarnings("unused")
public class PrimitiveConvert {

	public static void main(String[] args) {
		byte 	byte1 = 1, 			byte2 = 2;
		short 	short1 = byte1, 	short2 = 2;
		int 	int1 = short1, 		int2 = 2;
		long 	long1 = int1, 		long2 = 2L;
		float 	float1 = long1, 	float2 = 2.0F;
		double 	double1 = float1, 	double2 = 2.0;
		
		System.out.println(byte1 + "\t" + byte2);
		System.out.println(short1 + "\t" + short2);
		System.out.println(int1 + "\t" + int2);
		System.out.println(long1 + "\t" + long2);
		System.out.println(float1 + "\t" + float2);
		System.out.println(double1 + "\t" + double2);
		
		char char1 = 'A';
		int int3 = char1;
		System.out.println("A:" + int3);
		
		int int4 = (int) 3.14F;
		System.out.println("3.14F : " + int4);
		byte byte3 = (byte) 257;
		System.out.println("257 : " + byte3);
		
		// 运算时的类型转换
		byte3 = (byte) (byte1 + byte2);
		short short3 = (short) (short1 + short2);
		char char2 = (char) (char1 + 'a');
		System.out.println(char2);
		
		short test = (short) char2;
		System.out.println(test);
		
		char char3 = (char) test;
		System.out.println(char3);
		
		double dd = int1;
	}

}
