package TwoPhaseTermination.A2;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("main: BEGIN");
		
		try
		{
			// �Ұʰ����
			CountupThread t = new CountupThread();
			t.start();

			// �y�L�ťX�@�q�ɶ�
			Thread.sleep(10000);

			// �������e�X�פ�ШD
			System.out.println("main: shutdownRequest");
			t.shutdownRequest();

			System.out.println("main: join");

			// ���ݰ��������
			t.join();
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("main: END");
	}
}
