package Memento.Sample.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer
{
	private int money; // ��������`�B
	private List fruits = new ArrayList(); // ���G
	private Random random = new Random(); // �üƲ��;�
	private static String[] fruitsname =
	{ // ���G�W�٤@����
			"ī�G", "����", "����", "��l", };

	public Gamer(int money)
	{ // �غc�l
		this.money = money;
	}

	public int getMoney()
	{ // ���o�ثe����������`�B
		return money;
	}

	public void bet()
	{ // �U�`�K�}�l�C��
		int dice = random.nextInt(6) + 1; // �Y��l
		if (dice == 1)
		{ // ��1���K����������ܦh
			money += 100;
			System.out.println("��������W�[�F�C");
		}
		else if (dice == 2)
		{ // ��2���K��������Ѥ@�b
			money /= 2;
			System.out.println("��������Ѥ@�b�C");
		}
		else if (dice == 6)
		{ // ��6���K�o����G
			String f = getFruit();
			System.out.println("�o����G(" + f + ")�C");
			fruits.add(f);
		}
		else
		{ // ��L�K�S���o�ͤ����
			System.out.println("�S���o�ͤ���ơC");
		}
	}

	public Memento createMemento()
	{ // �ַӦs�ҡ]snapshot�^
		Memento m = new Memento(money);
		Iterator it = fruits.iterator();
		while (it.hasNext())
		{
			String f = (String) it.next();
			if (f.startsWith("�n�Y��"))
			{ // �u�x�s�n�Y�����G
				m.addFruit(f);
			}
		}
		return m;
	}

	public void restoreMemento(Memento memento)
	{ // �i��_��
		this.money = memento.money;
		this.fruits = memento.getFruits();
	}

	public String toString()
	{ // ��X���r��
		return "[money = " + money + ", fruits = " + fruits + "]";
	}

	private String getFruit()
	{ // �o��1�Ӥ��G
		String prefix = "";
		if (random.nextBoolean())
		{
			prefix = "�n�Y��";
		}
		return prefix + fruitsname[random.nextInt(fruitsname.length)];
	}
}
