package TwoPhaseTermination.A2;

public class CountupThread extends Thread
{
	// 計數器的值
	private long counter = 0;

	// 終止請求
	public void shutdownRequest()
	{
		interrupt();
	}

	// 動作
	public void run()
	{
		try
		{
			while (!isInterrupted())
			{
				doWork();
			}
		}
		catch (InterruptedException e)
		{
		}
		finally
		{
			doShutdown();
		}
	}

	// 作業
	private void doWork() throws InterruptedException
	{
		counter++;
		System.out.println("doWork: counter = " + counter);
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
		}
	}

	// 終止處理
	private void doShutdown()
	{
		System.out.println("doShutdown: counter = " + counter);
	}
}
