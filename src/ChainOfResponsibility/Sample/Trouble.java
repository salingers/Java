package ChainOfResponsibility.Sample;

public class Trouble
{
	private int number; // ���D�s��

	public Trouble(int number)
	{ // �o�Ͱ��D
		this.number = number;
	}

	public int getNumber()
	{ // ���o���D�s��
		return number;
	}

	public String toString()
	{ // �C�L��ܰ��D���r��
		return "[Trouble " + number + "]";
	}
}
