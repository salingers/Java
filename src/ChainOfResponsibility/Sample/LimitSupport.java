package ChainOfResponsibility.Sample;

public class LimitSupport extends Support
{
	private int limit; // �Y�p�󦹸��X�h�i�ѨM���D

	public LimitSupport(String name, int limit)
	{ // �غc�l
		super(name);
		this.limit = limit;
	}

	protected boolean resolve(Trouble trouble)
	{ // �ѨM����k
		if (trouble.getNumber() < limit)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
