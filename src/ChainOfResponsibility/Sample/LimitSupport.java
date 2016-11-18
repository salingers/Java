package ChainOfResponsibility.Sample;

public class LimitSupport extends Support
{
	 // �Y�p�󦹸��X�h�i�ѨM���D
	private int limit;

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
