package frank.java.chapter13.loader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 不同 ClassLoader 加载类的演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class URLClassLoaderDemo {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String path = System.getProperties().getProperty("user.dir");
		
		ClassLoader currentLoader = URLClassLoaderDemo.class.getClassLoader();
		// 为给定的 URL 构造新 URLClassLoader。首先在指定的父类加载器中搜索 URL，然后按照为类和资源指定的顺序搜索 URL。
		// 这里假定任何以 '/' 结束的 URL 都是指向目录的。如果不是以该字符结束，则认为该 URL 指向一个将根据需要下载和打开的 JAR 文件。 
		URLClassLoader urlLoader = new URLClassLoader(
				new URL[] {new URL("file:/" + path + "/data/")}, null);
		
		String classname = "frank.java.chapter13.loader.Person";
		Class<?> clzOne = urlLoader.loadClass(classname);
		Object p1 = clzOne.newInstance();
		System.out.println(clzOne);
		System.out.println(p1);
		
		Class<?> clzTwo = currentLoader.loadClass(classname);
		Object p2 = clzOne.newInstance();
		System.out.println(clzTwo);
		System.out.println(p2);
		
		// 不同 ClassLoader 就算加载相同的字节码，得到的 Class 也是不同的
		System.out.println(clzOne == clzTwo);
	}

}