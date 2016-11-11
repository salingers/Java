package util.concurrent;

import java.util.concurrent.*;

import util.concurrent.Consumer;
import util.concurrent.Producer;

public class ProducerConsumerDemo
{
	public static void main(String[] args)
	{

		BlockingQueue queue = new ArrayBlockingQueue(1); // 摰寥�1

		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}
