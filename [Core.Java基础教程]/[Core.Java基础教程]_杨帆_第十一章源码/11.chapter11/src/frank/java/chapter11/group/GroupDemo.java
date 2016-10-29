package frank.java.chapter11.group;

/**
 * 线程组统一控制多个线程的演示范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GroupDemo {

	static class GroupDemoRunner implements Runnable {
		@Override
		public void run() {
			int i = 0;
			while (!Thread.currentThread().isInterrupted()) {
				if (++i % 1000 == 0)
					System.out.println("\t\t"
							+ Thread.currentThread().getName() + "正在运行...");
				Thread.yield();
			}
			System.out.println("\t\t" + Thread.currentThread().getName()
					+ "停止!");
		}
	}

	static class CreateRunner implements Runnable {
		private String name;

		public CreateRunner(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			Thread t1 = new Thread(new GroupDemoRunner(), name + " one");
			t1.start();
			Thread t2 = new Thread(new GroupDemoRunner(), name + " two");
			t2.start();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("[main - zero]");
		GroupDemoRunner runner = new GroupDemoRunner();
		Thread t1 = new Thread(runner, "[main - one]");
		t1.start();
		Thread t2 = new Thread(runner, "[main - two]");
		t2.start();

		ThreadGroup group = new ThreadGroup("[sub - group]");
		group.setMaxPriority(Thread.MIN_PRIORITY);
		Thread s1 = new Thread(group, runner, "[sub - one]");
		s1.start();
		Thread s2 = new Thread(group, runner, "[sub - two]");
		s2.start();

		Thread.sleep(10);

		System.out.println("子线程组的内容：");
		Thread[] array = new Thread[group.activeCount()];
		group.enumerate(array);
		for (Thread t : array)
			System.out.println(t);

		// 中断整个线程组里的全部线程
		group.interrupt();

		Thread.sleep(10);
		t1.interrupt();
		t2.interrupt();
	}

}
