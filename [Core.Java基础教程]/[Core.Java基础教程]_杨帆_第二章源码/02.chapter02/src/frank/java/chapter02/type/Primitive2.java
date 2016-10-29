package frank.java.chapter02.type;

/**
 * 基本数据类型 - 字符型
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Primitive2 {
	
	private char char1;

	public static void main(String[] args) {
		Primitive2 type = new Primitive2();
		
		// 字符值在JVM内都是使用unicode表示的，String是由char构成的
		char char2 = 'A';
		char char3 = '中'; // 由于内部编码使用unicode所以一个中文也只算一个字符
		/* 常用转义字符值 \' \" \\ \t \n */
		char char4 = '\\'; // 对于一些特殊的字符可以使用转义字符'\'进行输出
		char char5 = '\u03A6'; // 可以直接以unicode的形式指定字符的值

		System.out.println("char1:" + type.char1); // 字符型的默认值为
		/*
		System.out.println("char1:" + '\0');
		System.out.println("char1:" + '\u0000');
		 */
		System.out.println("char2:" + char2);
		System.out.println("char3:" + char3);
		System.out.println("char4:" + char4);
		System.out.println("char5:" + char5);
	}

}
