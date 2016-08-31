package cc.openhome;

public class CallByValue
{
	public static void main(String[] args)
	{
		Customer c1 = new Customer("Justin");
		some(c1);
		System.out.println(c1.getFirstName());

		Customer c2 = new Customer("Justin");
		other(c2);
		System.out.println(c2.getFirstName());
	}

	static void some(Customer c)
	{
		c.setFirstName("John");
	}

	static void other(Customer c)
	{
		c = new Customer("Bill");
	}
}
