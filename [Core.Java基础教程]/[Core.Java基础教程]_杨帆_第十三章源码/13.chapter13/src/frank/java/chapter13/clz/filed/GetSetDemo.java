package frank.java.chapter13.clz.filed;

import java.lang.reflect.Field;

import frank.java.chapter13.Human;

/**
 * 使用反射获取/设置对象的属性范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GetSetDemo {

	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Class<Human> clz = Human.class;
		Human human = new Human("frank", 32);

		// 演示对公开属性的获取与设置
		Field fName = clz.getField("name");
		String name = (String) fName.get(human);
		System.out.println(name);
		fName.set(human, "法兰克");
		System.out.println(human);

		System.out.println("--------------------------");
		
		// 演示对非公开属性的获取与设置
		Field fSex = null;
		try {
			fSex = clz.getField("sex");
		} catch (NoSuchFieldException e) {
			System.out.println("无法通过 getField 获得非公开属性");
		} finally {
			fSex = clz.getDeclaredField("sex");
		}
		try {
			@SuppressWarnings("unused")
			boolean sex = fSex.getBoolean(human);
		} catch (IllegalAccessException e) {
			System.out.println("无法直接存取非公开属性");
		} finally {
			fSex.setAccessible(true);
			boolean sex = fSex.getBoolean(human);
			System.out.println(sex);
			fSex.set(human, true);
			System.out.println(human);
		}
	}

}
