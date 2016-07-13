import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class Timer extends Applet implements Runnable
{
	Button powerSwitch;
	Thread timeThread=null;
	String timeString;
	int msec,sec,min;

	public void init()
	{
		powerSwitch = new Button("Pause");

		powerSwitch.addActionListener(new ActionListener()
		{
			public synchronized void actionPerformed(ActionEvent e)
			{
				if (powerSwitch.getLabel() == "Start")
				{
					timeThread.resume();
					powerSwitch.setLabel("Pause");
				}
				else
				{
					timeThread.suspend();
					powerSwitch.setLabel("Start");
				}
			}
		});

		add(powerSwitch);

		setFont(new Font("TimesRoman" ,Font.BOLD ,30));
	}

	public void start()
	{
		timeThread=new Thread(this);
		timeThread.start();
	}

	public void stop()
	{
		timeThread=null;
	}

	public void paint(Graphics g)
	{
		if (min<=59)
		{
			if(sec<=59)
			{
				if(msec<=99)
					msec++;
				else
				{
					sec++;
					msec=0;
				}
			}
			else
			{
				min++;
				sec=0;
			}
		}
		else
			min=0;

		g.drawString(timeString,30,100);
	}

	public void run()
	{
		while(true)
		{	
			timeString = String.valueOf(min)
				+":"+(sec<10 ? "0"+String.valueOf(sec) : String.valueOf(sec))
				+":"+(msec<10 ? "0"+String.valueOf(msec) : String.valueOf(msec));

			try	{Thread.sleep(10);}
			catch ( InterruptedException e){}
			repaint();
		}
	}
}