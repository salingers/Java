package ChainOfResponsibility.Sample;

public abstract class Support
{
	private String name; // ���D�ѨM�̪��W��
	private Support next; // ��e��m

	public Support(String name)
	{ // ���Ͱ��D�ѨM��
		this.name = name;
	}

	public Support setNext(Support next)
	{ // �]�w��e��m
		this.next = next;
		return next;
	}

	public void support(Trouble trouble)
	{ // �ѨM���D���B�J
		if (resolve(trouble))
		{
			done(trouble);
		}
		else if (next != null)
		{
			next.support(trouble);
		}
		else
		{
			fail(trouble);
		}
	}

	public String toString()
	{ // �C�L�r��
		return "[" + name + "]";
	}

	protected abstract boolean resolve(Trouble trouble); // �ѨM����k

	protected void done(Trouble trouble)
	{ // �w�ѨM
		System.out.println(trouble + " is resolved by " + this + ".");
	}

	protected void fail(Trouble trouble)
	{ // �|���ѨM
		System.out.println(trouble + " cannot be resolved.");
	}
}
