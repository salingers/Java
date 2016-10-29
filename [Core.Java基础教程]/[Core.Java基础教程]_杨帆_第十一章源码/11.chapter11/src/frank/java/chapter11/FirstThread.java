package frank.java.chapter11;

/**
 * 线程入门范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class FirstThread {

	public static void main(String[] args) {
		HelloThread t = new HelloThread(10);
		t.setName("测试线程");
		t.start();
		System.out.println("main方法结束");
	}

}

/**
 * 使用继承方式创建线程
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
class HelloThread extends Thread {
	private int max;
	
	public HelloThread(int max) {
		this.max = max;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			System.out.println(
					Thread.currentThread().getName() + ":" + i);
		}
	}

}