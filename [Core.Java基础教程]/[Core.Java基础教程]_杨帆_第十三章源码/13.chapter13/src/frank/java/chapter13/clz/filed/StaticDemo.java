package frank.java.chapter13.clz.filed;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import frank.java.chapter13.Creature;

/**
 * 静态属性反射存取范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class StaticDemo {

	public static void main(String[] args) throws Exception {
		Class<Creature> clz = Creature.class;
		Field field = clz.getField("STATIC");
		System.out.println("该属性是否静态属性:" + Modifier.isStatic(field.getModifiers()));
		
		System.out.print("获取 : ");
		System.out.println(field.get(null));
		
		System.out.print("设置 : ");
		field.set(null, "new value one");
		System.out.println(Creature.STATIC);
	}

}
