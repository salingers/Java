package Threads.ch02;

import java.awt.*;

public class TimerThread extends Thread
{
	Component comp; // Component that need repainting
	int timediff; // Time between repaints of the component
	boolean shouldRun; // Set to false to stop thread

	public TimerThread(Component comp, int timediff)
	{
		this.comp = comp;
		this.timediff = timediff;
		shouldRun = true;
		setName("TimerThread(" + timediff + " milliseconds)");
	}

	public void run()
	{
		while (shouldRun)
		{
			try
			{
				comp.repaint();
				sleep(timediff);
			}
			catch (Exception e)
			{
			}
		}
	}
}
