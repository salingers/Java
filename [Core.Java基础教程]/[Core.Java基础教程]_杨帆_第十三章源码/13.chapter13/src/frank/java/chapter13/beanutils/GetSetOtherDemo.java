package frank.java.chapter13.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 使用 BeanUtils 化简属性获取的范例
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GetSetOtherDemo {

	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		OtherObject obj = new OtherObject();
		System.out.println(BeanUtils.getIndexedProperty(obj, "array[0]"));
		System.out.println(BeanUtils.getIndexedProperty(obj, "array", 1));

		System.out.println(BeanUtils.getIndexedProperty(obj, "list[0]"));
		System.out.println(BeanUtils.getIndexedProperty(obj, "list", 1));
		
		System.out.println(BeanUtils.getMappedProperty(obj, "map(one)"));
		System.out.println(BeanUtils.getMappedProperty(obj, "map", "two"));
	}

}
