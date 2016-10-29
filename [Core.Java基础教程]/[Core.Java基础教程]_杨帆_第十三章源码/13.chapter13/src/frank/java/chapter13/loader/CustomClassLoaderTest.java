package frank.java.chapter13.loader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoaderTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		encryptClass();
		String path = System.getProperties().getProperty("user.dir");
		String classname = "frank.java.chapter13.loader.Person";

		try {
			URLClassLoader loader = new URLClassLoader(new URL[] { new URL(
					"file:/" + path + "/encrypt/") }, null);
			Class<?> clz = loader.loadClass(classname);
		} catch (ClassFormatError e) {
			System.out.println("无法直接加载加密过的类");
		}
		
		DecodeClassLoader loader = new DecodeClassLoader(new URL[] { new URL(
				"file:/" + path + "/encrypt/") }, null);
		Class<?> clz = loader.loadClass(classname);
		System.out.println(clz);
		Object obj = clz.newInstance();
		System.out.println(obj);
	}

	private static void encryptClass() throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				new File("data/frank/java/chapter13/loader/Person.class")));
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(new File(
						"encrypt/frank/java/chapter13/loader/Person.class")));

		byte[] magic = "frank".getBytes();
		out.write(magic);
		int i;
		while ((i = in.read()) != -1)
			out.write(i);
		out.flush();
		out.close();
		in.close();
	}

}
