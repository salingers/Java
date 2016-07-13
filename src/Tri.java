import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Tri extends Applet
{
		Trictl ctl;
		Tricv c;

		public void init()
		{
				setLayout(new BorderLayout());
				add(c = new Tricv(), "Center");
				add(ctl = new Trictl(c), "South");
		}
}

class Tricv extends Canvas
{
		int wid = 100;

		public void paint(Graphics g)
		{
				int x, y;
				for (x = 0; x < wid; x++)
				{
						for (y = 0; y < wid; y++)
						{
								if ((x & (y - x)) == 0)
								{
										g.drawLine((int) (x + 150 - 0.5 * y), y, (int) (x + 150 - 0.5 * y), y);
								}
						}
						int rr = (int) (Math.random() * 255);
						int rg = (int) (Math.random() * 255);
						int rb = (int) (Math.random() * 255);
						g.setColor(new Color(rr, rg, rb));
				}
		}

		public Dimension getPreferredSize()
		{
				return new Dimension(300, 300);
		}

		public void draw(int wid)
		{
				this.wid = wid;
				repaint();
		}
}

class Trictl extends Panel implements ActionListener
{
		Tricv cv;
		TextField t1;

		public Trictl(Tricv cv)
		{
				this.cv = cv;
				Label label1 = new Label("½Ð¿é¤J¼Æ¦r:");
				t1 = new TextField("64", 4);
				t1.addActionListener(this);
				add(label1);
				add(t1);
		}

		public void actionPerformed(ActionEvent event)
		{
				cv.draw(Integer.parseInt(t1.getText().trim()));
		}
}
