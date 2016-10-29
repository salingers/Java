package frank.java.chapter11.wait;

/**
 * 消费者
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Consumer implements Runnable {
	
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		System.out.println("消费者购买产品......");

		for (int i = 1; i <= 10; i++) {
			try {
				// 等待随机时间
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 从店员处取走产品
			@SuppressWarnings("unused")
			Product p = clerk.buyProduct();
		}
	}
}