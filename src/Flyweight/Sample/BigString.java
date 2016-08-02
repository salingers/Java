package Flyweight.Sample;

public class BigString
{
	// �u�j����r�v���}�C
	private BigChar[] bigchars;

	// �غc�l
	public BigString(String string)
	{
		bigchars = new BigChar[string.length()];
		BigCharFactory factory = BigCharFactory.getInstance();
		for (int i = 0; i < bigchars.length; i++)
		{
			bigchars[i] = factory.getBigChar(string.charAt(i));
		}
	}

	// ���
	public void print()
	{
		for (int i = 0; i < bigchars.length; i++)
		{
			bigchars[i].print();
		}
	}
}
