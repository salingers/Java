
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Alarm extends Applet implements Runnable
{
	Thread timer = null;
	Image digit[], dot, dash, bg, imgalarm;
	Choice h1, h2, m1, m2;
	Label dotlab;
	Button set;
	AudioClip ling;
	int hour, min, i;
	String alm = "false";

	public void init()
	{
		ling = getAudioClip(getCodeBase(), "ling.au");
		digit = new Image[10];
		setFont(new Font("TimesRoman", Font.BOLD, 30));
		bg = getImage(getCodeBase(), "bg.jpg");
		dot = getImage(getCodeBase(), "dot.gif");
		dash = getImage(getCodeBase(), "dash.gif");
		imgalarm = getImage(getCodeBase(), "alm.gif");
		for (i = 0; i <= 9; i++)
		{
			digit[i] = getImage(getCodeBase(), "d" + i + ".gif");
		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 100));
		setFont(new Font("·s²Ó©úÅé", Font.PLAIN, 10));
		dotlab = new Label(":");
		set = new Button("¾xÄÁ°±¤î");
		h1 = new Choice();
		h1.addItem("0");
		h1.addItem("1");
		h1.addItem("2");

		h2 = new Choice();
		h2.addItem("0");
		h2.addItem("1");
		h2.addItem("2");
		h2.addItem("3");
		h2.addItem("4");
		h2.addItem("5");
		h2.addItem("6");
		h2.addItem("7");
		h2.addItem("8");
		h2.addItem("9");

		m1 = new Choice();
		m1.addItem("0");
		m1.addItem("1");
		m1.addItem("2");
		m1.addItem("3");
		m1.addItem("4");
		m1.addItem("5");

		m2 = new Choice();
		m2.addItem("0");
		m2.addItem("1");
		m2.addItem("2");
		m2.addItem("3");
		m2.addItem("4");
		m2.addItem("5");
		m2.addItem("6");
		m2.addItem("7");
		m2.addItem("8");
		m2.addItem("9");

		add(h1);
		add(h2);
		add(dotlab);
		add(m1);
		add(m2);

		add(set);
		set.addActionListener(new setalarm());
	}

	public void start()
	{
		if (timer == null)
		{
			timer = new Thread(this);
			timer.start();
		}
	}

	public void stop()
	{
		timer = null;
		ling.stop();
	}

	public void run()
	{
		while (timer != null)
		{
			repaint();
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
			}
		}
	}

	public int trans(char x)
	{
		return Integer.parseInt(String.valueOf(x));
	}

	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, this);
		g.setColor(Color.yellow);
		g.drawRect(103, 60, 135, 30);

		GregorianCalendar cal = new GregorianCalendar();

		g.setColor(Color.green);
		if (alm == "error")
			g.drawString("ERROR", 220, 30);
		if (alm == "true")
			g.drawImage(imgalarm, 220, 30, this);

		if (alm == "true" && hour == cal.get(Calendar.HOUR_OF_DAY) && min == cal.get(Calendar.MINUTE))
		{
			ling.loop();
		}

		g.drawImage(digit[(int) Math.floor((cal.get(Calendar.MONTH) + 1) / 10)], 115, 30, this);
		g.drawImage(digit[(cal.get(Calendar.MONTH) + 1) % 10], 130, 30, this);

		g.drawImage(dash, 145, 30, this);

		g.drawImage(digit[(int) Math.floor(cal.get(Calendar.DATE) / 10)], 160, 30, this);
		g.drawImage(digit[cal.get(Calendar.DATE) % 10], 175, 30, this);

		g.drawImage(digit[(int) Math.floor(cal.get(Calendar.HOUR_OF_DAY) / 10)], 110, 65, this);
		g.drawImage(digit[cal.get(Calendar.HOUR_OF_DAY) % 10], 125, 65, this);

		g.drawImage(dot, 140, 65, this);

		g.drawImage(digit[(int) Math.floor(cal.get(Calendar.MINUTE) / 10)], 155, 65, this);
		g.drawImage(digit[cal.get(Calendar.MINUTE) % 10], 170, 65, this);

		g.drawImage(dot, 185, 65, this);

		g.drawImage(digit[(int) Math.floor(cal.get(Calendar.SECOND) / 10)], 200, 65, this);
		g.drawImage(digit[cal.get(Calendar.SECOND) % 10], 215, 65, this);

	}

	public void update(Graphics g)
	{
		paint(g);
	}

	class setalarm implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			hour = ((h1.getSelectedIndex()) * 10 + h2.getSelectedIndex());
			min = ((m1.getSelectedIndex()) * 10 + m2.getSelectedIndex());
			if (hour >= 24)
			{
				alm = "error";
			}
			else
			{
				if (alm == "false")
				{
					alm = "true";
					set.setLabel("¾xÄÁ±Ò°Ê");
				}
				else
				{
					ling.stop();
					alm = "false";
					set.setLabel("¾xÄÁ°±¤î");
				}
			}
			repaint();

		}
	}
}