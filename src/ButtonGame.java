
//小瑪麗賭盤(ButtonGame.java)
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ButtonGame extends Applet
{
	Button myButton[] = new Button[11];
	Label myLabel;
	Panel NPanel, WPanel, EPanel, SPanel, CPanel, myPanel;
	Color c, c2;
	Font f = new Font("細明體", 1, 16);
	int Money = 100; // 預設錢數
	boolean start = false;
	int n[] = new int[10];

	public void init()
	{
		NPanel = new Panel();
		WPanel = new Panel();
		EPanel = new Panel();
		SPanel = new Panel();
		CPanel = new Panel();
		myPanel = new Panel();
		c = new Color(150, 150, 150);
		c2 = new Color(150, 255, 250);
		myLabel = new Label("錢數:" + String.valueOf(Money));
		this.setLayout(new BorderLayout());
		NPanel.setLayout(new GridLayout(1, 3, 5, 5));
		SPanel.setLayout(new GridLayout(1, 3, 5, 5));
		EPanel.setLayout(new GridLayout(2, 1, 5, 5));
		WPanel.setLayout(new GridLayout(2, 1, 5, 5));
		CPanel.setLayout(new BorderLayout());
		CPanel.add("Center", myPanel);
		myButton[10] = new Button("開始");
		CPanel.add("South", myButton[10]);
		myLabel.setFont(f);
		myPanel.add(myLabel);
		for (int i = 0; i < 10; i++)
		{
			myButton[i] = new Button("0");
			myButton[i].setBackground(c); // 設定按鈕顏色
		}

		for (int i = 0; i < 3; i++)
		{
			NPanel.add(myButton[i]);
		}
		for (int i = 3; i < 5; i++)
		{
			EPanel.add(myButton[i]);
		}
		for (int i = 7; i > 4; i--)
		{
			SPanel.add(myButton[i]);
		}
		for (int i = 9; i > 7; i--)
		{
			WPanel.add(myButton[i]);
		}

		this.add("Center", CPanel);
		this.add("North", NPanel);
		this.add("West", WPanel);
		this.add("East", EPanel);
		this.add("South", SPanel);
		for (int i = 0; i < 11; i++)
		{
			myButton[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent theEv)
				{
					myButton_actionPerformed(theEv);
				}
			});
		}
	}

	void myButton_actionPerformed(ActionEvent theEv)
	{
		if (Money == 0)
		{
			myLabel.setText("輸光了啦.!");
		} else
		{
			if (start == true)
			{
				for (int i = 0; i < 10; i++)
				{
					myButton[i].setLabel("0");
					n[i] = 0;
				}
			}
			start = false;
			for (int i = 0; i < 10; i++) // 下押錢數
			{
				myButton[i].setBackground(c);
				if (theEv.getSource() == myButton[i])
				{
					n[i]++;
					Money--;
					myLabel.setText("錢數" + String.valueOf(Money));
					myButton[i].setLabel(String.valueOf(n[i]));
				}
			}
		}
		if (theEv.getSource() == myButton[10]) // 開始
		{
			start = true; // 設定開始按鈕為已按下
			int Target;
			for (int i = 0; i < 200; i++) // 亂數閃動
			{
				Target = (int) Math.floor(Math.random() * 10);
				myButton[Target].setBackground(c2);
				myButton[Target].setBackground(c);
			}
			Target = (int) Math.floor(Math.random() * 10);
			myButton[Target].setBackground(c2); // 中獎按鈕變色

			for (int i = 0; i < 10; i++)
			{
				if (myButton[i].getBackground() == c2)
				{ // 獎金為下押錢數的五倍
					Money = Money + Integer.parseInt(myButton[i].getLabel()) * 5;
					myLabel.setText("錢數" + String.valueOf(Money));
				}
			}
		}
	}
}
