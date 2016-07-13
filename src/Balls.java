import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;

public class Balls extends Applet implements Runnable
{
	Thread	runThread = null;
	int 	windowX,windowY,
			speedX,speedY,
			positionX,positionY;
	boolean		turn_right = false,
				go_down	= true;
	Image		imgBuffer;
	Graphics	paintG;

	public void init()
	{
		windowX=this.getSize().width;
		windowY=this.getSize().height;
		imgBuffer = createImage(windowX,windowY);
		paintG = imgBuffer.getGraphics();
	}

	public void start()
	{
		if(runThread == null)
		{
			runThread = new Thread(this);
			runThread.start();
		}
		positionX = (int)(Math.random()*windowX);
		positionY = (int)(Math.random()*windowY+15);
		speedX=(int)(Math.random()*5+1);
		speedY=(int)(Math.random()*5+1);
	}

	public void stop()
	{
		runThread = null;
	}

	public void run()
	{
		while(true)
		{
			try	{Thread.sleep(50);}
			catch(InterruptedException e){}
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		if(go_down)
		{
			positionY += speedY;
			if(positionY + 15 == windowY)
			{
				go_down = false;
				speedY = (int)(Math.random()*5+1);
			}
		}
		else
		{
			positionY -= speedY;
			if(positionY == 0)
			{
				go_down = false;
				speedY = (int)(Math.random()*5+1);
			}
		}

		if(turn_right)
		{
			positionX += speedX;
			if(positionX + 15 == windowX)
			{
				turn_right = false;
				speedX = (int)(Math.random()*5+1);
			}
		}
		else
		{
			positionX -= speedX;
			if(positionX == 0)
			{
				turn_right = true;
				speedX = (int)(Math.random()*5+1);
			}
		}

		paintG.setColor(Color.lightGray);
		paintG.fillRect(0,0,windowX,windowY);
		paintG.setColor(Color.blue);
		paintG.fillOval(positionX,positionY,15,15);
		g.drawImage(imgBuffer,0,0,this);
	}

	public void update(Graphics g)
	{
		paint(g);
	}
}