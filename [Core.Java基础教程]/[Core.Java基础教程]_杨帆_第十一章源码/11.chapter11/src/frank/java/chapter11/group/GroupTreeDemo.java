package frank.java.chapter11.group;

/**
 * 线程组的继承关系演示
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class GroupTreeDemo {

	public static void main(String[] args) {
		ThreadGroup grpSub = new ThreadGroup("子线程组");
		Thread tSub = new Thread(grpSub, "子线程 one") {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted())
					Thread.yield();
			}
		};
		tSub.start();
		
		ThreadGroup grpMain = grpSub.getParent();
		ThreadGroup grpSystem = grpMain.getParent();
		ThreadGroup grpNull = grpSystem.getParent();
		System.out.println(grpNull);
		
		System.out.println("\n[子线程组的内容]");
		showThreadGroup(grpSub);
		System.out.println("\n[main线程组的内容]");
		showThreadGroup(grpMain);
		System.out.println("\n[system线程组的内容]");
		showThreadGroup(grpSystem);
		
		grpSystem.interrupt();
	}

	private static void showThreadGroup(ThreadGroup group) {
		System.out.println(group);
		Thread[] array = new Thread[group.activeCount()];
		group.enumerate(array);
		for (Thread t : array) {
			System.out.println(t);
		}
	}

}
