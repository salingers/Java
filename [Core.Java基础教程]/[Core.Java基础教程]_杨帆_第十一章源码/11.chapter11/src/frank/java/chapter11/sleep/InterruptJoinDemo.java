package frank.java.chapter11.sleep;

/**
 * 使用 interrupt 干扰 join 中的线程的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InterruptJoinDemo {

	public static void main(String[] args) {
		
		final Thread main = Thread.currentThread();
		
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				main.interrupt();
			}
		
		};
		t.setName("[线程1]");
		Thread.currentThread().setName("主线程");
		t.start(); // 线程要在启动状态
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("主线程被干扰抛出了异常");
		}
		
		System.out.println("over");
	}

}
