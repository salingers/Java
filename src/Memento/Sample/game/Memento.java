package Memento.Sample.game;

import java.util.ArrayList;
import java.util.List;

public class Memento
{
	int money; // ��������`�B
	ArrayList fruits; // ���G

	public int getMoney()
	{ // ���o��������`�B�]narrow interface�^
		return money;
	}

	Memento(int money)
	{ // �غc�l�]wide interface�^
		this.money = money;
		this.fruits = new ArrayList();
	}

	void addFruit(String fruit)
	{ // �s�W���G�]wide interface�^
		fruits.add(fruit);
	}

	List getFruits()
	{ // ���o(wide interface)
		return (List) fruits.clone();
	}
}
