package frank.java.chapter11.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue 使用范例<br/>
 * 重新实现生产者和消费者范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
		Thread p1 = new Thread(new Producer(queue), "P-One");
		p1.start();
		//Thread p2 = new Thread(new Producer(queue), "P-Two");
		//p2.start();
		Thread c1 = new Thread(new Consumer(queue), "C-One");
		c1.start();
		//Thread c2 = new Thread(new Consumer(queue), "C-Two");
		//c2.start();
	}

}

class Producer implements Runnable {
	
	private BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.put(Thread.currentThread().getName() + " 产品 " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	
	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + 
						" 消费:" + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
