package frank.java.chapter11.basic;

/**
 * 控制线程停止的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class StopThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		CanStopRunner runner = new CanStopRunner();
		Thread t = new Thread(runner);
		t.start();
		Thread.sleep(1000);
		runner.stop();
	}

}

class CanStopRunner implements Runnable {
	
	private boolean stop = false;

	@Override
	public void run() {
		while (!stop) {
			System.out.println("线程正在运行...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 改变状态标记，使线程终止 */
	public void stop() {
		stop = true;
	}
}
