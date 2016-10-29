package frank.java.chapter11.basic;

public class DeamonDemo {
	
	static class DeamonRunner implements Runnable {
		private int max;
		
		public DeamonRunner(int max) {
			this.max = max;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < max; i++) {
				System.out.println(
						Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(
					Thread.currentThread().getName() + "结束");
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new DeamonRunner(100));
		t1.setName("后台线程");
		t1.setDaemon(true);
		t1.start();
		
		Thread t2 = new Thread(new DeamonRunner(5));
		t2.setName("普通线程");
		t2.start();
		
		Thread main = Thread.currentThread();
		System.out.println("[main]当前线程:" + main.getName());
		int total = Thread.activeCount();
		System.out.println("[main]活动线程数:" + total);
		Thread[] threads = new Thread[total];
		Thread.enumerate(threads);
		for (Thread t : threads) {
			System.out.println("[main]" + t.getName() + ":" + (t.isDaemon() ? "后台" : "用户"));
		}
		
		System.out.println("[main]主线程结束");
	}

}
