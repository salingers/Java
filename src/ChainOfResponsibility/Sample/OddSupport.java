package ChainOfResponsibility.Sample;

public class OddSupport extends Support
{
	public OddSupport(String name)
	{ // �غc�l
		super(name);
	}

	protected boolean resolve(Trouble trouble)
	{ // �ѨM����k
		if (trouble.getNumber() % 2 == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
