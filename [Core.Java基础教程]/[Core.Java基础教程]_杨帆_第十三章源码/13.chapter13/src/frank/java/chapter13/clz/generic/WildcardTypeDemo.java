package frank.java.chapter13.clz.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;

/**
 * 反射获取类型通配符信息的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class WildcardTypeDemo {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException, NoSuchMethodException {
		Class<WildcardTypeObject> clz = WildcardTypeObject.class;
		Field field = clz.getField("list");
		// 先获取参数化类型
		ParameterizedType type = (ParameterizedType) field.getGenericType();
		// 再获取通配符类型
		WildcardType wType = (WildcardType) type.getActualTypeArguments()[0];
		// 最后就可得到通配符类型的上限和下限了
		System.out.println(Arrays.toString(wType.getUpperBounds()));
		System.out.println(Arrays.toString(wType.getLowerBounds()));
	}

}

class WildcardTypeObject {
	public List<? super Number> list;
}