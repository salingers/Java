package util.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
	private BlockingQueue<Integer> productQueue;

	public Consumer(BlockingQueue<Integer> productQueue)
	{
		this.productQueue = productQueue;
	}

	public void run()
	{

		for (int i = 1; i <= 10; i++)
		{
			try
			{
				int product = productQueue.take();
			}
			catch (InterruptedException ex)
			{
				throw new RuntimeException(ex);
			}
		}
	}
}
