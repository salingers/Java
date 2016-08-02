package Memento.Sample.game;

import java.util.ArrayList;
import java.util.List;

public class Memento
{
	int money; // 手邊金錢總額
	ArrayList fruits; // 水果

	public int getMoney()
	{ // 取得手邊金錢總額（narrow interface）
		return money;
	}

	Memento(int money)
	{ // 建構子（wide interface）
		this.money = money;
		this.fruits = new ArrayList();
	}

	void addFruit(String fruit)
	{ // 新增水果（wide interface）
		fruits.add(fruit);
	}

	List getFruits()
	{ // 取得(wide interface)
		return (List) fruits.clone();
	}
}
