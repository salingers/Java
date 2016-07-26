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
			System.out.println("Step 3 (never reached here)"); // 不會到這裡來
		}
	}

	public static void magic(final Object obj)
	{
		// thread會取得obj的lock，變成等待自己結束的執行緒
		Thread thread = new Thread()
		{
			public void run()
			{
				synchronized (obj)
				{ // 在這裡取得obj的鎖定
					synchronized (this)
					{
						this.notifyAll(); // 通知已經取得obj的鎖定
					}
					try
					{
						this.join(); // 永遠等待
					}
					catch (InterruptedException e)
					{
					}
				}
			}
		};
		synchronized (thread)
		{
			thread.start(); // 執行緒的啟動
			try
			{
				thread.wait(); // 等待新的執行緒取得obj的鎖定
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
