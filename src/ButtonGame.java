
//�p���R��L(ButtonGame.java)
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ButtonGame extends Applet
{
	Button myButton[] = new Button[11];
	Label myLabel;
	Panel NPanel, WPanel, EPanel, SPanel, CPanel, myPanel;
	Color c, c2;
	Font f = new Font("�ө���", 1, 16);
	int Money = 100; // �w�]����
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
		myLabel = new Label("����:" + String.valueOf(Money));
		this.setLayout(new BorderLayout());
		NPanel.setLayout(new GridLayout(1, 3, 5, 5));
		SPanel.setLayout(new GridLayout(1, 3, 5, 5));
		EPanel.setLayout(new GridLayout(2, 1, 5, 5));
		WPanel.setLayout(new GridLayout(2, 1, 5, 5));
		CPanel.setLayout(new BorderLayout());
		CPanel.add("Center", myPanel);
		myButton[10] = new Button("�}�l");
		CPanel.add("South", myButton[10]);
		myLabel.setFont(f);
		myPanel.add(myLabel);
		for (int i = 0; i < 10; i++)
		{
			myButton[i] = new Button("0");
			myButton[i].setBackground(c); // �]�w���s�C��
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
			myLabel.setText("����F��.!");
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
			for (int i = 0; i < 10; i++) // �U�����
			{
				myButton[i].setBackground(c);
				if (theEv.getSource() == myButton[i])
				{
					n[i]++;
					Money--;
					myLabel.setText("����" + String.valueOf(Money));
					myButton[i].setLabel(String.valueOf(n[i]));
				}
			}
		}
		if (theEv.getSource() == myButton[10]) // �}�l
		{
			start = true; // �]�w�}�l���s���w���U
			int Target;
			for (int i = 0; i < 200; i++) // �üư{��
			{
				Target = (int) Math.floor(Math.random() * 10);
				myButton[Target].setBackground(c2);
				myButton[Target].setBackground(c);
			}
			Target = (int) Math.floor(Math.random() * 10);
			myButton[Target].setBackground(c2); // �������s�ܦ�

			for (int i = 0; i < 10; i++)
			{
				if (myButton[i].getBackground() == c2)
				{ // �������U����ƪ�����
					Money = Money + Integer.parseInt(myButton[i].getLabel()) * 5;
					myLabel.setText("����" + String.valueOf(Money));
				}
			}
		}
	}
}
