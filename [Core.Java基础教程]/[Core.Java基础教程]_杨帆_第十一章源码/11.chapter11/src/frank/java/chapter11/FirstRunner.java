package frank.java.chapter11;

/**
 * 线程入门范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class FirstRunner {

	public static void main(String[] args) {
		HelloRunner r = new HelloRunner(1000);
		Thread t1 = new Thread(r, "[线程 One]");
		Thread t2 = new Thread(r, "[线程 Two]");
		t1.start();
		t2.start();
	}
	
}

/**
 * 使用实现 Runnable 方式来创建线程
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
class HelloRunner implements Runnable {

	int max;
	
	public HelloRunner(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		for (; max > 0; max--) {
			System.out.println(
					Thread.currentThread().getName() + ":" + max);
		}
	}
}
