package frank.java.chapter11.wait;

/**
 * 生产者对象
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Producer implements Runnable {
	
	private Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		System.out.println("生产者开始生产产品......");
		for (int i = 1; i <= 10; i++) {
			try {
				// 暂停随机时间
				Thread.sleep((int) Math.random() * 3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Product p = new Product(Thread.currentThread().getName() + "产品" + i);
			// 将产品交给店员
			clerk.receiveProduct(p);
		}
	}
}