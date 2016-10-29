package frank.java.chapter11.wait;

/**
 * 生产者与消费者测试范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		// 生产者线程
		Thread p1 = new Thread(new Producer(clerk));
		p1.setName("Frank");
		p1.start();
		Thread p2 = new Thread(new Producer(clerk));
		p2.setName("Jack");
		p2.start();
		// 消费者线程
		Thread c1 = new Thread(new Consumer(clerk));
		c1.start();
		Thread c2 = new Thread(new Consumer(clerk));
		c2.start();
	}
	
}