package frank.java.chapter11.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * 售货员
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Clerk {

	// 货架对象，用来存放生产出来的产品
	private List<Product> store = new ArrayList<Product>();
	// 货架可以存放的最大产品数量
	private static int MAX = 5;

	// 这个方法由生产者调用
	// 生产者把产品生产出来，然后调用该方法把产品交给售货员
	public synchronized void receiveProduct(Product product) {
		if (store.size() >= MAX) {
			try {
				// 目前没有空间收产品，请稍候！
				wait(); // 必须在同步块或方法中才能使用 wait
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		store.add(product);
		System.out.printf("库存状态(%d) 新产品(%s)%n", store.size(), product.getCode());

		// 通知等待区中的一个消费者可以继续工作了
		notify();
	}

	// 这个方法由消费者调用
	public synchronized Product buyProduct() {
		if (store.size() == 0) {
			try {
				// 缺货了，请稍候！
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Product p = store.remove(0);
		System.out.printf("库存状态(%d) 取走产品(%s)%n", store.size(), p.getCode());
		// 通知等待区中的一个生产者可以继续工作了
		notify(); // notify 和 interrupt 会使等待区域的线程回到锁定池的 Blocked 状态
		return p;
	}
}
