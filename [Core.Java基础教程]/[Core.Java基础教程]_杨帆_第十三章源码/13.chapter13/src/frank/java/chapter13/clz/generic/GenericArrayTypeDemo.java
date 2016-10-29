package frank.java.chapter13.clz.generic;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;

/**
 * 获取泛型数组类型的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GenericArrayTypeDemo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws SecurityException,
			NoSuchFieldException {
		Class<GenericArray> clz1 = GenericArray.class;
		Field field1 = clz1.getField("array");
		GenericArrayType type1 = (GenericArrayType) field1.getGenericType();
		// 获取泛型的元素类型
		System.out.println(type1.getGenericComponentType());
	}

}

class GenericArray<T> {
	public T[] array;
}

