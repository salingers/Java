package frank.java.chapter11.group;

/**
 * 线程组统一异常处理范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GroupExceptionHandlerDemo {
	
	static class ThrowExceptionRunner implements Runnable {
		@Override
		public void run() {
			throw new RuntimeException(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("测试组") {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("捕获到 " + t.getName() + " 的异常:" + e);
			}
		};
		//ThreadGroup group = new ThreadGroup("测试组");
		Runnable runner = new ThrowExceptionRunner();
		
		Thread t1 = new Thread(group, runner, "测试线程 one");
		Thread t2 = new Thread(group, runner, "测试线程 two");
		t1.start();
		t2.start();
	}

}
