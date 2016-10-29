import java.util.Arrays;


public class DeadLock {

	public static void main(String[] args) {
		class MyThread extends Thread {
			
			private char[] source;
			private char[] dest;
			
			public MyThread(char[] source, char[] dest) {
				this.source = source;
				this.dest = dest;
			}
			
			@Override
			public void run() {
				System.out.println(this.getName() + "线程开始");
				synchronized (source) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (dest) {
						dest = Arrays.copyOf(source, source.length);
					}
				}
				System.out.println(this.getName() + "线程结束");
			}
		};

		char[] c1 = {'A', 'B', 'C', 'D'};
		char[] c2 = {'1', '2', '3', '4'};
		
		MyThread t1 = new MyThread(c1, c2);
		t1.start();
		
		MyThread t2 = new MyThread(c2, c1);
		t2.start();
		
	}

}
