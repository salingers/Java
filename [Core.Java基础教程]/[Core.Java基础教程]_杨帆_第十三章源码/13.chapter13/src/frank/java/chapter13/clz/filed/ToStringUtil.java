package frank.java.chapter13.clz.filed;

import java.lang.reflect.Field;

import frank.java.chapter13.Human;

/**
 * ToStringUtil 演示如何使用反射完成通用的 ToString 工具
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public abstract class ToStringUtil {
	
	public static String toString(Object obj) {
		Class<?> clz = obj.getClass();
		StringBuilder builder = new StringBuilder();
		for (Field f : clz.getDeclaredFields()) {
			builder.append(f.getName());
			builder.append("=");
			f.setAccessible(true);
			try {
				builder.append(f.get(obj));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			builder.append(", ");
		}
		if (builder.length() > 0)
			builder.delete(builder.length() - 2, builder.length());
		return clz.getSimpleName() + " [" + builder + "]";
	}

	public static void main(String[] args) {
		Human human = new Human("Frank", 32);
		System.out.println(ToStringUtil.toString(human));
	}

}
