package frank.java.chapter13.beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 使用 BeanUtils 化简属性存取的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GetSetDemo {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		
		BeanUtils.setProperty(student, "name", "Frank");
		BeanUtils.setProperty(student, "age", 32);
		BeanUtils.setProperty(student, "sex", "true");
		BeanUtils.setProperty(student, "address", new Address());
		BeanUtils.setProperty(student, "address.code", "510000");
		BeanUtils.setProperty(student, "address.detail", "GuangZhou, China");
		
		System.out.println(student);

		System.out.println("名称:" + BeanUtils.getProperty(student, "name"));
		System.out.println("年龄:" + BeanUtils.getProperty(student, "age"));
		System.out.println("性别:" + BeanUtils.getProperty(student, "sex"));
		System.out.println("地址(邮编):" + BeanUtils.getProperty(student, "address.code"));
		System.out.println("地址(详情):" + BeanUtils.getProperty(student, "address.detail"));
	}

}
