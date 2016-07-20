
import java.awt.*;
import java.awt.event.*;
import java.lang.Runnable;
import java.util.*;

public class NewScrollBar extends Canvas implements MouseMotionListener, MouseListener, Runnable
{
	private Color barColor = Color.blue;
	private int value = 0, maxx, maxy;
	private transient Thread thread = null;
	private int newValue = 0;
	private int delayTime = 10;
	private transient Vector valueChangeListeners;

	public NewScrollBar()
	{
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		if (thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
	}

	public static void main(String args[])
	{
		Frame f = new Frame();
		f.setSize(300, 150);
		f.add(new NewScrollBar());
		f.setVisible(true);
	}

	public int getValue()
	{
		return value;
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mousePressed(MouseEvent e)
	{
		newValue = e.getX();
		thread.resume();
	}

	public void mouseReleased(MouseEvent e)
	{
		thread.suspend();
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseDragged(MouseEvent e)
	{
		newValue = e.getX();
		ValueChangeEvent vce = new ValueChangeEvent(this, value);
		fireValueChanged(vce);
	}

	public void mouseMoved(MouseEvent e)
	{
	}

	public void run()
	{
		while (true)
		{
			repaint();
			try
			{
				Thread.sleep(delayTime);
			}
			catch (InterruptedException e)
			{
			}
			ValueChangeEvent vce = new ValueChangeEvent(this, value);
			fireValueChanged(vce);
		}
	}

	public void update(Graphics g)
	{
		paint(g);
	}

	public void paint(Graphics g)
	{
		maxx = getSize().width;
		maxy = getSize().height;

		g.setColor(this.barColor);

		if (value < newValue)
		{
			g.fillRect(0, 0, value, maxy);
			value = value + 2;
		}
		else if (value > newValue)
		{
			value = value - 2;
			g.clearRect(value, 0, 2, maxy);
			g.fillRect(0, 0, value, maxy);
		}
	}

	public synchronized void removeValueChangeListener(ValueChangeListener l)
	{
		if (valueChangeListeners != null && valueChangeListeners.contains(l))
		{
			Vector v = (Vector) valueChangeListeners.clone();
			v.removeElement(l);
			valueChangeListeners = v;
		}
	}

	public synchronized void addValueChangeListener(ValueChangeListener l)
	{
		Vector v = valueChangeListeners == null ? new Vector(2) : (Vector) valueChangeListeners.clone();
		if (!v.contains(l))
		{
			v.addElement(l);
			valueChangeListeners = v;
		}
	}

	protected void fireValueChanged(ValueChangeEvent e)
	{
		if (valueChangeListeners != null)
		{
			Vector listeners = valueChangeListeners;
			int count = listeners.size();
			for (int i = 0; i < count; i++)
				((ValueChangeListener) listeners.elementAt(i)).valueChanged(e);
		}
	}
}
