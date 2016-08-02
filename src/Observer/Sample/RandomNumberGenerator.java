package Observer.Sample;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator
{
	private Random random = new Random(); // �üƲ��;�
	private int number; // �ثe�ƭ�

	public int getNumber()
	{ // ���o�ƭ�
		return number;
	}

	public void execute()
	{
		for (int i = 0; i < 20; i++)
		{
			number = random.nextInt(50);
			notifyObservers();
		}
	}
}
