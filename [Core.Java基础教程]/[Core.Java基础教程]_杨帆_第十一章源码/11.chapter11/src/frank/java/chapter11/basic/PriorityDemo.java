package frank.java.chapter11.basic;

/**
 * 线程优先级别范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class PriorityDemo {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("主线程的默认级别:" + main.getPriority());
		main.setPriority(Thread.MIN_PRIORITY);
		
		Thread t1 = new Thread(new Runner());
		t1.setName("线程1");
		t1.setPriority(Thread.MIN_PRIORITY); //默认优先级
		t1.start();
		
		Thread t2 = new Thread(new Runner());
		t2.setName("线程2");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		System.out.println("主线程结束");
	}
	
	private static class Runner implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				if (i % 10000 == 0) {
					String name = Thread.currentThread().getName();
					System.out.println(name + ":" + i / 100);
				}
			}
		}
	}

}
