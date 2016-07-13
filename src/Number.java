import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Number extends Applet implements ActionListener, KeyListener
{
		Button myButton;
		Label myLabel;
		TextField myText;
		int i, Y, A, B, n1, n2, n3, n4, t1, t2, t3, t4;
		String N1, N2, N3, N4, T1, T2, T3, T4;

		public void init()
		{
				setLayout(new GridLayout(8, 2, 50, 0));
				Font f = new Font("細明體", Font.BOLD, 16);
				myButton = new Button("確定");
				myLabel = new Label("請輸入四位數字");
				myText = new TextField("");
				myText.setFont(f);
				add(myLabel);
				add(myText);
				add(myButton);
				myText.addKeyListener(this);
				myButton.addActionListener(this);
				getNum();
		}

		void getNum()
		{
				Y = 0;
				N1 = String.valueOf((int) Math.floor(Math.random() * 10));
				n1 = Integer.parseInt(N1);
				do
				{
						N2 = String.valueOf((int) Math.floor(Math.random() * 10));
						n2 = Integer.parseInt(N2);
				} while (n2 == n1);
				do
				{
						N3 = String.valueOf((int) Math.floor(Math.random() * 10));
						n3 = Integer.parseInt(N3);
				} while (n3 == n2 || n3 == n1);
				do
				{
						N4 = String.valueOf((int) Math.floor(Math.random() * 10));
						n4 = Integer.parseInt(N4);
				} while (n4 == n3 || n4 == n2 || n4 == n1);
		}

		public void actionPerformed(ActionEvent theEv)
		{
				if (myButton.getLabel() == "重玩")
				{
						getNum();
						myText.setText("");
						myLabel.setText("請輸入四位數");
						repaint();
				} else
				{
						T1 = String.valueOf(myText.getText().charAt(0));
						T2 = String.valueOf(myText.getText().charAt(1));
						T3 = String.valueOf(myText.getText().charAt(2));
						T4 = String.valueOf(myText.getText().charAt(3));
						t1 = Integer.parseInt(T1);
						t2 = Integer.parseInt(T2);
						t3 = Integer.parseInt(T3);
						t4 = Integer.parseInt(T4);
						if (n1 == t1)
								A++;
						else if (n1 == t2 || n1 == t3 || n1 == t4)
								B++;
						if (n2 == t2)
								A++;
						else if (n2 == t1 || n2 == t3 || n2 == t4)
								B++;
						if (n3 == t3)
								A++;
						else if (n3 == t1 || n3 == t2 || n3 == t4)
								B++;
						if (n4 == t4)
								A++;
						else if (n4 == t1 || n4 == t2 || n4 == t3)
								B++;
						if (A == 4 || Y == 10)
						{
								if (Y == 10)
										myLabel.setText("笨死了!答案是:" + N1 + N2 + N3 + N4);
								else
										myLabel.setText("答對了!給你鼓鼓掌!");
								myButton.setLabel("重玩");
						} else
						{
								repaint();
								myText.setText("");
						}
				}
		}

		public void keyTyped(KeyEvent theEv)
		{
		}

		public void keyPressed(KeyEvent theEv)
		{
				if (myText.getText().length() == 4)
				{
						if (theEv.getKeyCode() != theEv.VK_BACK_SPACE)
								theEv.consume();
				}
		}

		public void keyReleased(KeyEvent theEv)
		{
		}

		public void paint(Graphics g)
		{
				if (T1 != null)
				{
						g.drawString(T1 + T2 + T3 + T4 + "    " + String.valueOf(A) + "A" + String.valueOf(B) + "B", 10,
										100 + Y * 10);
						Y++;
				}
				A = 0;
				B = 0;
				if (myButton.getLabel() == "重玩")
				{
						g.clearRect(0, 10, 100, 200);
						myButton.setLabel("確定");
				}
		}

		public void update(Graphics g)
		{
				paint(g);
		}
}