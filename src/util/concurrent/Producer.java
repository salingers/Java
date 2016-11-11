package util.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private BlockingQueue<Integer> productQueue;

	public Producer(BlockingQueue<Integer> productQueue)
	{
		this.productQueue = productQueue;
	}

	public void run()
	{
		System.out.println("��������......");
		for (int product = 1; product <= 10; product++)
		{
			try
			{
				productQueue.put(product);
				System.out.printf("������ (%d)%n", product);
			}
			catch (InterruptedException ex)
			{
				throw new RuntimeException(ex);
			}
		}
	}
}
