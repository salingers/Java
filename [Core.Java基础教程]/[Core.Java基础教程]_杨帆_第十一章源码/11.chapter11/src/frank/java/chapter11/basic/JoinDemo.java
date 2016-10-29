package frank.java.chapter11.basic;

/**
 * 线程排队范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		
		class Runner implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					if (i % 100 == 0) {
						String name = Thread.currentThread().getName();
						System.out.println(name + ":" + i / 100);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		Thread t = new Thread(new Runner());
		t.setName("[线程1]");
		Thread.currentThread().setName("主线程");
		t.start(); // 线程要在启动状态
		t.join();
		
		for (int i = 0; i < 10000; i++) {
			if (i % 100 == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":" + i / 100);
				Thread.sleep(10);
			}
		}
	}

}
