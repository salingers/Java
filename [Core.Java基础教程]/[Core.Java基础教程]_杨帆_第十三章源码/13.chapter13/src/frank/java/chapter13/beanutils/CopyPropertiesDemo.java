package frank.java.chapter13.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 复制属性值范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class CopyPropertiesDemo {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Student s = new Student();
		s.setName("Frank");
		s.setAge(32);
		s.setSex(true);
		
		Teacher t = new Teacher();
		BeanUtils.copyProperties(t, s);
		System.out.println(t);
	}

}
