package frank.java.chapter11.wait;

/**
 * 线程交互的入门范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class First {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		final Object obj = new Object();
		
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj) {
					obj.notify();
					System.out.println("叫醒他了");
				}
			}
		};
		t.start();
		
		Thread.sleep(500);
		
		synchronized (obj) {
			try {
				obj.wait();
				System.out.println("醒来了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
