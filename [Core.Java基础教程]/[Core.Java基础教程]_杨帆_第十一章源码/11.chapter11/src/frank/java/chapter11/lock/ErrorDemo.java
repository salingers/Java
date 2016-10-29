package frank.java.chapter11.lock;

/**
 * 缺少同步带来的错误范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ErrorDemo {

	static class SellTicket implements Runnable { // 实现了Runnable接口
		private int ticket = 10; // 一共是10张票
		public void run() { // 覆写Thread类中的run()方法
			while(true) {
				if (this.ticket > 0) {
					try {
						Thread.sleep(100); // 加入延迟操作
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("卖票 --> 剩余 =  " + --this.ticket);
				} else {
					break; // 票卖完了，线程退出
				}
			}
		}
	}

	public static void main(String[] args) {
		SellTicket my = new SellTicket();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		Thread t3 = new Thread(my);
		t1.start();
		t2.start();
		t3.start();
	}

}
