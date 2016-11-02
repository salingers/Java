package frank.java.chapter13.loader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 蝞����摰�� ClassLoader ����
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class DecodeClassLoader extends URLClassLoader
{

	public DecodeClassLoader(URL[] urls)
	{
		super(urls);
	}

	public DecodeClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory)
	{
		super(urls, parent, factory);
	}

	public DecodeClassLoader(URL[] urls, ClassLoader parent)
	{
		super(urls, parent);
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException
	{
		if (!name.startsWith("frank"))
			return super.loadClass(name);
		try
		{
			byte[] contents = loadClassData(name);
			return defineClass(name, contents, 5, contents.length - 5);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private byte[] loadClassData(String name) throws IOException, URISyntaxException
	{
		String path = name.replace('.', '/') + ".class";
		URL url = this.findResource(path);
		URI uri = url.toURI();
		FileInputStream input = new FileInputStream(new File(uri));
		BufferedInputStream in = new BufferedInputStream(input);
		List<Byte> contents = new ArrayList<Byte>();
		for (int i; (i = in.read()) != -1;)
			contents.add((byte) i);
		byte[] result = new byte[contents.size()];
		for (int i = 0; i < contents.size(); i++)
			result[i] = contents.get(i);
		return result;
	}

}
