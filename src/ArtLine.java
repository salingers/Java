import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ArtLine extends Applet
{
	Linectl ctl;
	Linecv c;

	public void init()
	{
		setLayout(new BorderLayout());
		add(c = new Linecv(), "Center");
		add(ctl = new Linectl(c), "South");
	}
}

class Linecv extends Canvas
{
	boolean filled = false;
	int edges = 5;

	public void paint(Graphics g)
	{
		int i = 1, j = 1, m = edges;
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = 0;
		Dimension size = getSize();
		for (i = 1; i <= m; i++)
		{
			x1 = (int) (this.getSize().width / 2 + 100 * Math.cos(2 * Math.PI * i / m));
			y1 = (int) (this.getSize().height / 2 + 100 * Math.sin(2 * Math.PI * i / m));
			for (j = 1; j <= m; j++)
			{
				x2 = (int) (this.getSize().width / 2 + 100 * Math.cos(2 * Math.PI * j / m));
				y2 = (int) (this.getSize().height / 2 + 100 * Math.sin(2 * Math.PI * j / m));
				g.drawLine(x1, y1, x2, y2);
			}
			int rr = (int) (Math.random() * 256);
			int rg = (int) (Math.random() * 256);
			int rb = (int) (Math.random() * 256);
			g.setColor(new Color(rr, rg, rb));
		}
	}

	public void redraw(boolean filled, int edges)
	{
		this.filled = filled;
		this.edges = edges;
		repaint();
	}
}

class Linectl extends Panel implements ActionListener
{
	Label l;
	TextField s;
	Linecv cv;

	public Linectl(Linecv cv)
	{
		Button b = null;
		this.cv = cv;
		l = new Label("請輸入邊數:");
		s = new TextField("5", 4);
		b = new Button("Draw");
		b.addActionListener(this);
		add(l);
		add(s);
		add(b);
	}

	public void actionPerformed(ActionEvent ev)
	{
		String label = ev.getActionCommand();
		cv.redraw(label.equals("Draw"), Integer.parseInt(s.getText().trim()));
	}
}
