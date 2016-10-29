package frank.java.chapter11.sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * suspend / resume / stop 方法演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class SupendDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
				while (true) {
					Date now = new Date();
					System.out.println(df.format(now));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		
		System.out.println("启动时间输出线程");
		Thread.sleep(3000);
		
		System.out.println("暂停...");
		t.suspend();
		Thread.sleep(6000);
		
		System.out.println("恢复...");
		t.resume();
		Thread.sleep(6000);
		
		System.out.println("退出...");
		t.stop();
	}

}
