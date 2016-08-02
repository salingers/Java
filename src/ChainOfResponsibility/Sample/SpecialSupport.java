package ChainOfResponsibility.Sample;

public class SpecialSupport extends Support
{
	private int number; // �u��ѨM�����X�����D

	public SpecialSupport(String name, int number)
	{ // �غc�l
		super(name);
		this.number = number;
	}

	protected boolean resolve(Trouble trouble)
	{ // �ѨM����k
		if (trouble.getNumber() == number)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
