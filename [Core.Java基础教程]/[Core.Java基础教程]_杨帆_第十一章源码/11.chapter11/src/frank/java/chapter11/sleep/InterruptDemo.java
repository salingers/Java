package frank.java.chapter11.sleep;

/**
 * 使用 interrupt 方法来终止 sleep 的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InterruptDemo {
	
	private static class MyThread extends Thread {
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + ":开始干活了");
			System.out.println(name + ":我好困，先睡会咯");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("是谁吵醒老子的");
			}
			System.out.println("终于干完活了");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread();
		t.setName("测试线程");
		t.start();
		
		System.out.println("主线程:我也睡会");
		Thread.sleep(2000);
		System.out.println("主线程:我醒了，该叫那混蛋起来了");
		t.interrupt();
	}

}
