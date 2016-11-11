package lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import javax.xml.bind.Marshaller.Listener;

public class ClientListenerInstaller
{
	private Queue queue;
	private Map<String, Method> methods = new HashMap<>();

	public ClientListenerInstaller(Queue queue) throws Exception
	{
		this.queue = queue;
	}

	public void install(Class<?> clz) throws Exception
	{
		collectAnnotatedMethods(clz);

		// 撱箇�誨��隞�
		Object listenerProxy = Proxy.newProxyInstance(Listener.class.getClassLoader(), new Class[]
		{ Listener.class }, (proxy, method, args) -> methods.get(method.getName()).invoke(clz.newInstance(), args));

		// �隞���隞嗡�酉���
		Method addclientListener = queue.getClass().getMethod("addClientListener", Listener.class);

		addclientListener.invoke(queue, listenerProxy);
	}

	private void collectAnnotatedMethods(Class<?> clz) throws SecurityException
	{
		for (Method method : clz.getMethods())
		{
			Annotation annotation = method.getAnnotation(Annotation.class);

			if (annotation != null)
			{
				methods.put("clientAdded", method);
			}
		}
	}
}