package lang;

import static java.lang.System.out;

public class ClassInfo
{
	public static void main(String[] args)
	{
		Class clz = String.class;

		out.println(clz.getName());
		out.println(clz.isInterface());
		out.println(clz.isPrimitive());
		out.println(clz.isArray());
		out.println(clz.getSuperclass().getName());
	}
}
