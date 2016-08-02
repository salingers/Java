package Flyweight.Sample;

import java.util.HashMap;

public class BigCharFactory
{
	// �޲z�{����BigChar���������
	private HashMap pool = new HashMap();
	// Singleton Pattern
	private static BigCharFactory singleton = new BigCharFactory();

	// �غc�l
	private BigCharFactory()
	{
	}

	// ���o�ߤ@���������
	public static BigCharFactory getInstance()
	{
		return singleton;
	}

	// ���͡]�@�Ρ^BigChar���������
	public synchronized BigChar getBigChar(char charname)
	{
		BigChar bc = (BigChar) pool.get("" + charname);
		if (bc == null)
		{
			bc = new BigChar(charname); // �b������BigChar���������
			pool.put("" + charname, bc);
		}
		return bc;
	}
}
