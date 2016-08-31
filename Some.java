package cc.openhome;

public class Some
{
	static
	{
		System.out.println("載入 Some.class 檔案");
	}
	

	void someMethod(int i)
	{
		System.out.println("int 版本被呼叫");
	}

	void someMethod(Integer integer)
	{
		System.out.println("Integer 版本被呼叫");
	}
}
