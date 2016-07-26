package GuardedSuspension.A6;

public class Main
{
	public static void main(String[] args)
	{
		// �Ұʰ����
		RequestQueue requestQueue = new RequestQueue();
		Thread alice = new ClientThread(requestQueue, "Alice", 314159L);
		Thread bobby = new ServerThread(requestQueue, "Bobby", 265358L);
		alice.start();
		bobby.start();

		// ���ݬ�10��
		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
		}

		// �I�sinterrupt��k
		System.out.println("***** calling interrupt *****");
		alice.interrupt();
		bobby.interrupt();
	}
}
