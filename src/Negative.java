import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.applet.*;

public class Negative extends Applet
{

	Image pard, inverpard;
	int width, height;
	Button tran;
	String status = "false";

	public void init()
	{
		MediaTracker tracker = new MediaTracker(this);
		pard = getImage(getCodeBase(), "pard.gif");
		tracker.addImage(pard, 0);
		try
		{
			tracker.waitForID(0);
		}
		catch (InterruptedException e)
		{
		}
		;

		width = pard.getWidth(this);
		height = pard.getHeight(this);
		resize(width, height);
		int pix[] = new int[width * height];
		tran = new Button("Âà´«");
		add(tran);
		tran.addActionListener(new act());
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 65));
		PixelGrabber pg = new PixelGrabber(pard, 0, 0, width, height, pix, 0, width);
		try
		{
			pg.grabPixels();
		}
		catch (InterruptedException e)
		{
		}
		;

		for (int index = 0; index < width * height; index++)
			pix[index] = pix[index] ^ 0xffffff;

		inverpard = createImage(new MemoryImageSource(width, height, pix, 0, width));
	}

	public void paint(Graphics g)
	{
		if (status == "true")
			g.drawImage(inverpard, 0, 0, this);
		else
			g.drawImage(pard, 0, 0, this);
	}

	class act implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (status == "false")
				status = "true";
			else
				status = "false";
			repaint();
		}
	}
}
