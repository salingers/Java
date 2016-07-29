package TwoPhaseTermination.A2;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("main: BEGIN");
		
		try
		{
			// 啟動執行緒
			CountupThread t = new CountupThread();
			t.start();

			// 稍微空出一段時間
			Thread.sleep(10000);

			// 對執行緒送出終止請求
			System.out.println("main: shutdownRequest");
			t.shutdownRequest();

			System.out.println("main: join");

			// 等待執行緒結束
			t.join();
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("main: END");
	}
}
