package ThreadPerMessage.A7_2;

public class Blackhole
{
	public static void enter(Object obj)
	{
		System.out.println("Step 1");
		magic(obj);
		System.out.println("Step 2");
		synchronized (obj)
		{
			System.out.println("Step 3 (never reached here)"); // ���|��o�̨�
		}
	}

	public static void magic(final Object obj)
	{
		// thread�|���oobj��lock�A�ܦ����ݦۤv�����������
		Thread thread = new Thread()
		{
			public void run()
			{
				synchronized (obj)
				{ // �b�o�̨��oobj����w
					synchronized (this)
					{
						this.notifyAll(); // �q���w�g���oobj����w
					}
					try
					{
						this.join(); // �û�����
					}
					catch (InterruptedException e)
					{
					}
				}
			}
		};
		synchronized (thread)
		{
			thread.start(); // ��������Ұ�
			try
			{
				thread.wait(); // ���ݷs����������oobj����w
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
