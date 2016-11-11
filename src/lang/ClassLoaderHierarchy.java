package lang;

import static java.lang.System.out;

public class ClassLoaderHierarchy
{
	public static void main(String[] args)
	{
		Some some = new Some(); // ���ome撖虫��

		Class clz = some.getClass(); // ���ome.class��lass撖虫��

		ClassLoader loader = clz.getClassLoader(); // ���lassLoader

		out.println(loader);
		out.println(loader.getParent()); // ���ClassLoader
		out.println(loader.getParent().getParent()); // ����ClassLoader
	}
}
