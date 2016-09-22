package ClassLoader;

import static java.lang.System.out;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo
{
	public static void main(String[] args)
	{
		try
		{
			String path = args[0]; // 皜祈岫頝臬��
			String clzName = args[1]; // 皜祈岫憿

			Class clz1 = loadClassFrom(path, clzName);
			out.println(clz1);
			
			Class clz2 = loadClassFrom(path, clzName);
			out.println(clz2);

			out.printf("clz1 ��� clz2 �%s撖虫��", clz1 == clz2 ? "����" : "銝��");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			out.println("瘝����頛頝臬���迂");
		}
		catch (MalformedURLException e)
		{
			out.println("頛頝臬�隤�");
		}
		catch (ClassNotFoundException e)
		{
			out.println("�銝�����");
		}
	}

	private static Class loadClassFrom(String path, String clzName) throws ClassNotFoundException, MalformedURLException
	{
		ClassLoader loader = new URLClassLoader(new URL[]
		{ new URL(path) });
		return loader.loadClass(clzName);
	}
}
