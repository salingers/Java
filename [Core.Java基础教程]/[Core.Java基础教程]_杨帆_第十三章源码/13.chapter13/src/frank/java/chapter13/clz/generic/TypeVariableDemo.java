package frank.java.chapter13.clz.generic;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 通过反射获得类型变量信息的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class TypeVariableDemo {

	public static void main(String[] args) {
		GenericObject<Integer> obj = new GenericObject<Integer>();
		Class<?> clz = obj.getClass();
		for (TypeVariable<?> t : clz.getTypeParameters()) {
			// 获得类型变量名
			System.out.println("name:" + t.getName());
			System.out.println("bound:");
			// 获得类型变量的上限类型
			for (Type type : t.getBounds()) {
				System.out.println(type);
			}
		}
	}

}

/**
 * 测试用的泛型对象
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
class GenericObject<T extends Number & Serializable> {
	
	private T number;

	public T getNumber() {
		return number;
	}

	public void setNumber(T number) {
		this.number = number;
	}
}
