import java.awt.*;
import java.applet.Applet;

public class Pro_Con extends Applet
{
		int Data[];
		Rectangle rect[];
		Producer p;
		Consumer c;

		public void init()
		{
				Data = new int[5];
				rect = new Rectangle[5];
				for (int i = 0; i < 5; i++)
				{
						Data[i] = 0;
						rect[i] = new Rectangle(getSize().width / 2, getSize().height / 6 * i, getSize().height / 6,
										getSize().height / 6);
				}
				p = new Producer(this, getGraphics());
				c = new Consumer(this, getGraphics());
		}

		public void start()
		{
				if (p != null)
						p.start();
				if (c != null)
						c.start();
		}

		public void setData(int Data[])
		{
				this.Data = Data;
		}

		public int[] getData()
		{
				return Data;
		}

		public void update(Graphics g)
		{
				paint(g);
		}

		public void paint(Graphics g)
		{
				g.setColor(Color.blue);
				for (int i = 0; i < 5; i++)
				{
						g.clearRect(rect[i].x, rect[i].y, rect[i].width, rect[i].height);
						if (Data[i] == 1)
								g.fillOval(rect[i].x, rect[i].y, rect[i].width, rect[i].height);
						else
								g.drawOval(rect[i].x, rect[i].y, rect[i].width, rect[i].height);
				}
				g.clearRect(10, getSize().height - 60, 80, 20);
				g.drawString("Produced" + String.valueOf(p.getCount()), 10, getSize().height - 40);

				g.clearRect(10, getSize().height - 40, 80, 20);
				g.drawString("Consumed" + String.valueOf(c.getCount()), 10, getSize().height - 20);
		}
}

class Producer extends Thread
{
		Pro_Con P_C;
		int Data[], counts;
		Graphics g;
		int found = -1;

		public Producer(Pro_Con P_C, Graphics g)
		{
				this.P_C = P_C;
				this.Data = P_C.getData();
				this.g = g;
				counts = 0;
		}

		public int getCount()
		{
				return counts;
		}

		public void run()
		{
				while (true)
				{
						synchronized (Data)
						{
								found = -1;
								int i = 4;
								while (found == -1 && i >= 0)
								{
										if (Data[i] == 0)
										{
												found = i;
												Data[i] = 1;
												counts++;
										}
										i--;
								}
						}
						P_C.setData(Data);
						P_C.repaint();

						try
						{
								Thread.sleep(500 + 500 * (int) Math.floor(Math.random() * 4));
						} catch (InterruptedException e)
						{
						}
				}
		}
}

class Consumer extends Thread
{
		Pro_Con P_C;
		int Data[], counts;
		Graphics g;
		int found = -1;

		public Consumer(Pro_Con P_C, Graphics g)
		{
				this.P_C = P_C;
				this.Data = P_C.getData();
				this.g = g;
				counts = 0;
		}

		public int getCount()
		{
				return counts;
		}

		public void run()
		{
				while (true)
				{
						synchronized (Data)
						{
								found = -1;
								int i = 0;

								while (found == -1 && i < 5)
								{
										if (Data[i] == 1)
										{
												found = i;
												Data[i] = 0;
												counts++;
										}
										i++;
								}
						}
						P_C.setData(Data);
						P_C.repaint();

						try
						{
								Thread.sleep(500 + 500 * (int) Math.floor(Math.random() * 4));
						} catch (InterruptedException e)
						{
						}
				}
		}
}