package frank.java.chapter13.anno;

/**
 * ���釣閫��擖啗���
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class MyObject
{

	@SuppressWarnings("unused")
	private int unused;

	@Deprecated
	public static void deprectated()
	{

	}

	@Override
	public String toString()
	{
		return super.toString();
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		MyObject obj = new MyObject();
		obj.deprectated();
	}
}
