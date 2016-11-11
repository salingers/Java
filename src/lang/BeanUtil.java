package lang;

import java.lang.reflect.*;
import java.util.*;

public class BeanUtil
{
	public static <T> T getBean(Map<String, Object> data, String clzName) throws Exception
	{
		Class clz = Class.forName(clzName);
		Object bean = clz.newInstance();

		data.entrySet().forEach(entry ->
		{
			String setter = String.format("set%s%s", entry.getKey().substring(0, 1).toUpperCase(),
					entry.getKey().substring(1));
			try
			{
				// ���瘜�迂��������� Method 撖虫��
				Method method = clz.getMethod(setter, entry.getValue().getClass());
				// 敹����瘜�
				if (Modifier.isPublic(method.getModifiers()))
				{
					// ���祕靘���澆��瘜�
					method.invoke(bean, entry.getValue());
				}
			}
			catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException
					| InvocationTargetException ex)
			{
				throw new RuntimeException(ex);
			}
		});

		return (T) bean;
	}
}
