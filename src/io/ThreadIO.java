package io;

import java.io.*;

public class ThreadIO
{
	PipedWriter pw1to2;
	PipedReader pr2to1;
	PipedThread pipedthread1;
	PipedThread pipedthread2;
	Thread t1 = null;
	Thread t2 = null;

	public void init()
	{
		pw1to2 = new PipedWriter();
		pr2to1 = new PipedReader();

		try
		{
			pw1to2.connect(pr2to1);
			pr2to1.connect(pw1to2);
		}
		catch (IOException ioe)
		{
		}
		pipedthread1 = new PipedThread(pw1to2);
		pipedthread2 = new PipedThread(pr2to1);

		t1 = new Thread(pipedthread1);
		t2 = new Thread(pipedthread2);

	}

	public void start()
	{
		if (t1 != null)
			t1.start();
		if (t2 != null)
			t2.start();
	}

}

class PipedThread implements Runnable
{
	PipedWriter pw;
	PipedReader pr;

	int mode = -1;

	public PipedThread(PipedWriter pw)
	{
		mode = 0;
		this.pw = pw;
	}

	public PipedThread(PipedReader pr)
	{
		mode = 1;
		this.pr = pr;
	}

	public void run()
	{
		int i = 0;
		while (true)
		{
			if (mode == 0)
			{
				char writeTo[] = new char[1];
				try
				{
					writeTo[0] = (char) Math.floor(Math.random() * 256);
					pw.write(writeTo, 0, 1);
					pw.flush();

				}
				catch (IOException ioe)
				{
				}
			}
			else if (mode == 1)
			{
				char readFrom[] = new char[1];
				try
				{
					int s = pr.read(readFrom, i, 1);
					if (s == -1)
					{
						// 沒資料
					}
					else
					{
						// 讀到
					}
					i++;
				}
				catch (IOException ioe)
				{
				}
			}
			try
			{
				Thread.sleep(1000);
			}
			// try {Thread.sleep(500+500*(int)Math.floor(Math.random() * 4)); }
			catch (InterruptedException e)
			{
			}
		}
	}
}
