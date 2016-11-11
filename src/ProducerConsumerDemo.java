

import java.util.concurrent.*;

public class ProducerConsumerDemo
{
	public static void main(String[] args)
	{

		BlockingQueue queue = new ArrayBlockingQueue(1); // 容量為1
		
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}
