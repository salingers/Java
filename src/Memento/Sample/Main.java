package Memento.Sample;

import Memento.Sample.game.Gamer;
import Memento.Sample.game.Memento;

public class Main
{
	public static void main(String[] args)
	{
		Gamer gamer = new Gamer(100); // �@�}�l��������`�B��100
		Memento memento = gamer.createMemento(); // �w���x�s�̪쪬�A
		for (int i = 0; i < 100; i++)
		{
			System.out.println("==== " + i); // ��X����
			System.out.println("�{�p:" + gamer); // ��X�D�H�Ϊ��ثe���A

			gamer.bet(); // �i��C��

			System.out.println("��������`�B��" + gamer.getMoney() + "���C");

			// �M�w�p��B�zMemento
			if (gamer.getMoney() > memento.getMoney())
			{
				System.out.println("    �]�]���w�gĹ�F���֡A�G���x�s�ثe���A�^");
				memento = gamer.createMemento();
			}
			else if (gamer.getMoney() < memento.getMoney() / 2)
			{
				System.out.println("    �]�]���w�g��F�ܦh�A�G��_��e�����A�^");
				gamer.restoreMemento(memento);
			}

			// ����
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
			}
			System.out.println("");
		}
	}
}
