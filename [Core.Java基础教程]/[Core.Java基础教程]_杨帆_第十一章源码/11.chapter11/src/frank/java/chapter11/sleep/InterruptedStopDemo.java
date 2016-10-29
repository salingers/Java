package frank.java.chapter11.sleep;

/**
 * 使用中断方法来实现线程退出的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InterruptedStopDemo {

	public static void main(String[] args) throws InterruptedException {
		CanInterruptRunner runner = new CanInterruptRunner();
		Thread t = new Thread(runner);
		t.start();
		Thread.sleep(10);
		t.interrupt();
	}

}

class CanInterruptRunner implements Runnable {
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("线程正在运行...");
		}
		// 重置线程的中断状态
		Thread.interrupted();
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println("线程受到干扰退出");
	}
	
}
