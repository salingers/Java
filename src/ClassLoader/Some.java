package ClassLoader;

public class Some
{
	static
	{
		System.out.println("頛 Some.class 瑼��");
	}
	

	void someMethod(int i)
	{
		System.out.println("int ��鋡怠�");
	}

	void someMethod(Integer integer)
	{
		System.out.println("Integer ��鋡怠�");
	}
}
