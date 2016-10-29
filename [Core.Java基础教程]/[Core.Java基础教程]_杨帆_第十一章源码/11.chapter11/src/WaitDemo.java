
public class WaitDemo {

	public static void main(String[] args) {
		final String mutex = "去米国";
		
		Thread pilot = new Thread(){
			@Override
			public void run() {
				System.out.println("飞机起飞了");
				for (int i = 0; i < 18; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("飞机在飞：" + i);
				}
				synchronized (mutex) {
					System.out.println("目的地到了，要叫醒乘客了");
					mutex.notifyAll();
				}
			}
		};
		
		System.out.println("乘客上飞机。");
		pilot.start();
		synchronized (mutex) {
			try {
				mutex.wait();
				System.out.println("乘客下飞机。");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
