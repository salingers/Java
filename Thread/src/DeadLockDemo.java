

class Resources
{
	private String name;
	private int resource;

	Resources(String name, int resource)
	{
		this.name = name;
		this.resource = resource;
	}

	String getName()
	{
		return name;
	}

	synchronized int doSome()
	{
		return ++resource;
	}

	synchronized void cooperate(Resources resource)
	{
		resource.doSome();
		System.out.printf("%s 整合 %s 的資源%n", this.name, resource.getName());
	}
}

public class DeadLockDemo
{
	public static void main(String[] args)
	{
		Resources resource1 = new Resources("resource1", 10);
		Resources resource2 = new Resources("resource2", 20);

		Thread thread1 = new Thread(() ->
		{
			for (int i = 0; i < 10; i++)
			{
				resource1.cooperate(resource2);
			}
		});
		Thread thread2 = new Thread(() ->
		{
			for (int i = 0; i < 10; i++)
			{
				resource2.cooperate(resource1);
			}
		});

		thread1.start();
		thread2.start();
	}
}
