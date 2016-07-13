import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.lang.Runnable;
import java.io.*;

public class ScrollWord extends Canvas implements Runnable, MouseListener, Serializable
{

		protected Color enterColor, exitColor, backColor;
		protected String outText;
		protected Point p;
		protected transient Thread thread = null;
		protected Dimension h_w = new Dimension(50, 25);
		protected boolean Go = true, enter_exit = false;
		protected int speed = 100;
		protected Font font;
		protected PropertyChangeSupport pcs = new PropertyChangeSupport(this);

		public ScrollWord(String s, int maxx, int maxy)
		{
				this.h_w = new Dimension(maxx, maxy);
				this.enterColor = Color.green;
				this.exitColor = Color.red;

				this.backColor = Color.blue;
				outText = s;
				p = new Point(h_w.width, h_w.height);
				font = new Font("細明體", Font.BOLD, getSize().height / 2);
				this.addMouseListener(this);
				if (thread == null)
				{
						thread = new Thread(this);
						thread.start();
				}
				setGo(true);
		}

		public ScrollWord()
		{
				this.h_w = new Dimension(50, 25);
				this.enterColor = Color.green;
				this.exitColor = Color.red;
				this.backColor = Color.blue;
				outText = "REX";
				p = new Point(h_w.width, h_w.height);
				font = new Font("細明體", Font.BOLD, getSize().height / 2);
				this.addMouseListener(this);
				if (thread == null)
				{
						thread = new Thread(this);
						thread.start();
				}
				setGo(true);
		}

		public void run()
		{
				while (true)
				{
						repaint();
						try
						{
								Thread.sleep(speed);
						} catch (InterruptedException e)
						{
						}
				}
		}

		public void addPropertyChangeListener(PropertyChangeListener l)
		{
				pcs.addPropertyChangeListener(l);
		}

		public void removePropertyChangeListener(PropertyChangeListener l)
		{
				pcs.removePropertyChangeListener(l);
		}

		public boolean isGo()
		{
				return Go;
		}

		public void setGo(boolean go)
		{
				Go = go;
				if (Go)
				{
						thread.resume();
				} else
				{
						thread.suspend();
				}
		}

		public void setEnterColor(Color c)
		{
				this.enterColor = c;
				pcs.firePropertyChange("EnterColor", enterColor, c);
		}

		public Color getEnterColor()
		{
				return this.enterColor;
		}

		public void setExitColor(Color c)
		{
				pcs.firePropertyChange("ExitColor", exitColor, c);
				this.exitColor = c;
		}

		public Color getExitColor()
		{
				return this.exitColor;
		}

		public void setbackColor(Color c)
		{
				this.backColor = c;
				pcs.firePropertyChange("backColor", backColor, c);
		}

		public Color getbackColor()
		{
				return this.backColor;
		}

		public void setSpeed(int s)
		{
				pcs.firePropertyChange("Speed", new Integer(speed), new Integer(s));
				this.speed = s;
		}

		public int getSpeed()
		{
				return this.speed;
		}

		public Font getFont()
		{
				return font;
		}

		public void setFont(Font f)
		{
				this.font = f;
		}

		public void setOutText(String text)
		{
				pcs.firePropertyChange("OutText", outText, text);
				this.outText = text;
		}

		public String getOutText()
		{
				return outText;
		}

		public Dimension getpreferredSize()
		{
				return h_w;
		}

		public void mouseClicked(MouseEvent e)
		{
		}

		public void mousePressed(MouseEvent e)
		{
		}

		public void mouseReleased(MouseEvent e)
		{
		}

		public void mouseEntered(MouseEvent e)
		{
				enter_exit = true;
		}

		public void mouseExited(MouseEvent e)
		{
				enter_exit = false;
		}

		public void update(Graphics g)
		{
				paint(g);
		}

		public void paint(Graphics g)
		{
				font = new Font("細明體", Font.BOLD, getSize().height / 2);
				FontMetrics fm = g.getFontMetrics(font);
				// int swidth=fm.stringWidth(outText);
				int sheight = fm.getHeight();

				g.setFont(font);
				g.setColor(this.backColor);
				g.fillRect(0, 0, getSize().width, getSize().height);

				if (enter_exit)
				{
						g.setColor(this.enterColor);
				} else
				{
						g.setColor(this.exitColor);
				}

				g.drawString(outText, p.x, (getSize().height + sheight) / 2);
				p.x = p.x - 10;
				if (p.x + outText.length() * font.getSize() <= 0)
				{
						p.x = getSize().width;
				}
		}

		private void writeObject(ObjectOutputStream oos) throws IOException
		{
				oos.defaultWriteObject();
		}

		private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException
		{
				ois.defaultReadObject();
				if (thread == null)
				{
						thread = new Thread(this);
						thread.start();
				}
		}
}
