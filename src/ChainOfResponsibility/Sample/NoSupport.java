package ChainOfResponsibility.Sample;

public class NoSupport extends Support
{
	public NoSupport(String name)
	{
		super(name);
	}

	protected boolean resolve(Trouble trouble)
	{ // �ѨM����k
		return false; // �ۤv�����B�z
	}
}
