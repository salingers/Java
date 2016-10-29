package frank.java.chapter02.type;

import static java.lang.System.out;

/**
 * 基本数据类型 - 浮点型
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Primitive4 {
	
	private float float1;
	private double double1;

	public static void main(String[] args) {
		
		// float 长度为4个字节
		// 由于 Java 默认的浮点数都是 double 型的，所以要赋浮点型的值要在结尾加F
		float float2 = 3.14F; 		// 一般赋值法
		float float3 = 1.1e1F; 		// 科学计数赋值法
		float float4 = 1.1E-1F;
		float float5 = 0x1.1p1F; 	// 16进制赋值法(P后面跟的是以2为底的指数)
		float float6 = 0x1.1P-1F;
		// double 长度为8个字节
		double double2 = 3.14; 		// 3.14D
		double double3 = 1.1e1;		// 1.1E1D
		double double4 = 1.1E-1;
		double double5 = 0x1.1p1;	// 0x1.1P1D
		double double6 = 0x1.1P-1;
		
		Primitive4 type = new Primitive4();
		out.println("float");
		out.println("1:" + type.float1 + "\t2:" + float2 + "\t3:" + float3 + "\t4:" + float4 +
				"\t5:" + float5 + "\t6:" + float6);
		out.println("double");
		out.println("1:" + type.double1 + "\t2:" + double2 + "\t3:" + double3 + "\t4:" + 
				double4 + "\t5:" + double5 + "\t6:" + double6);

	}

}
