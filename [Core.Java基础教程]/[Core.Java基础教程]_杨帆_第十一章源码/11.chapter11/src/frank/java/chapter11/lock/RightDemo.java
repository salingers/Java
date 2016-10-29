package frank.java.chapter11.lock;

/**
 * 使用同步修正多线程并发错误的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class RightDemo {

	static class SellTicket implements Runnable { // 实现了Runnable接口
		private Integer ticket = 10; // 一共是10张票
		public void run() { // 覆写Thread类中的run()方法
			for (int i = 0; i < 100; i++) {
				synchronized (this) {
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
