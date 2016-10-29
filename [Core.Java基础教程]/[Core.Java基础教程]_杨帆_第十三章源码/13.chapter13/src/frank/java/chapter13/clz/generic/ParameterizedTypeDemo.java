package frank.java.chapter13.clz.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * 通过反射获取参数类型的实际类型的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ParameterizedTypeDemo {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Class<PersonDao> clz = PersonDao.class;
		Method method = clz.getMethod("load", Object.class);
		System.out.println(method);
		
		// 获得泛型的超类类型
		ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
		// 获得实际类型参数
		System.out.println(Arrays.toString(type.getActualTypeArguments()));
	}

}

class Dao<T, PK> {	
	public T load(PK pk) {
		return null;
	}
}

class PersonDao extends Dao<Person, Integer> {
}