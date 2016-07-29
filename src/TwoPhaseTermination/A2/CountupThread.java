package TwoPhaseTermination.A2;

public class CountupThread extends Thread
{
	// �p�ƾ�����
	private long counter = 0;

	// �פ�ШD
	public void shutdownRequest()
	{
		interrupt();
	}

	// �ʧ@
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

	// �@�~
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

	// �פ�B�z
	private void doShutdown()
	{
		System.out.println("doShutdown: counter = " + counter);
	}
}
