
import java.awt.*;
import java.io.Serializable;

public class Bean1 extends Canvas implements Serializable
{
		private int[] data;
		private java.awt.Color[] showColor;
		private String[] dataTitle;
		private String title = "Title";

		public static void main(String args[])
		{
				Frame f = new Frame("teST");
				f.setSize(200, 100);
				f.add(new Bean1());
				f.setVisible(true);
		}

		public Bean1()
		{
				data = new int[4];
				dataTitle = new String[4];
				for (int i = 0; i < data.length; i++)
				{
						data[i] = i + 1;
						dataTitle[i] = String.valueOf(i + 1) + " Data";
				}
				showColor = new Color[4];
				showColor[0] = Color.red;
				showColor[1] = Color.green;
				showColor[2] = Color.blue;
				showColor[3] = Color.yellow;
		}

		public void paint(Graphics g)
		{
				int total = 0;
				int maxx, maxy, len;
				Point p, po;

				maxx = getSize().width;
				maxy = getSize().height;
				p = new Point(maxx / 10, maxy / 10);

				if (maxx >= maxy)
						len = maxy * 4 / 5;
				else
						len = maxx * 4 / 5;
				po = new Point(p.x + len / 2, p.y + len / 2);

				System.out.println(maxx);

				for (int i = 0; i < data.length; i++)
						total = total + data[i];

				double startAngle = 0;
				double arcAngle = 0;

				double x, y;

				for (int i = 0; i < data.length; i++)
				{
						g.setColor(showColor[i]);
						arcAngle = data[i] * 360 / total;
						g.fillArc(p.x, p.y, len, len, (int) startAngle, (int) arcAngle);

						g.setColor(Color.black);
						x = po.x + Math.cos(-(startAngle + arcAngle / 2) * Math.PI / 180) * len / 2;
						y = po.y + Math.sin(-(startAngle + arcAngle / 2) * Math.PI / 180) * len / 2;
						g.drawString(dataTitle[i], (int) x, (int) y);

						startAngle = startAngle + (data[i] * 360 / total);
				}

				g.drawString(title, maxx / 2, maxy);
		}

		public void setData(int[] newData)
		{
				data = newData;
		}

		public int[] getData()
		{
				return data;
		}

		public Dimension getPreferredSize()
		{
				return new Dimension(50, 25);
		}

		public void setShowColor(java.awt.Color[] newShowColor)
		{
				showColor = newShowColor;
		}

		public java.awt.Color[] getShowColor()
		{
				return showColor;
		}

		public void setDataTitle(String[] newDataTitle)
		{
				dataTitle = newDataTitle;
		}

		public String[] getDataTitle()
		{
				return dataTitle;
		}

		public void setTitle(String newTitle)
		{
				title = newTitle;
		}

		public String getTitle()
		{
				return title;
		}
}
