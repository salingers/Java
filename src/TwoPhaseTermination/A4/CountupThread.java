package TwoPhaseTermination.A4;

public class CountupThread extends GracefulThread
{
	// 計數器的值
	private long counter = 0;

	// 作業
	protected void doWork() throws InterruptedException
	{
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}

	// 終止處理
	protected void doShutdown()
	{
		System.out.println("doShutdown: counter = " + counter);
	}
}
