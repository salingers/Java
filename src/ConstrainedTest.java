
import java.awt.*;
import java.beans.*;

public class ConstrainedTest extends Canvas implements VetoableChangeListener
{
	private transient PropertyChangeSupport propertyChangeListeners = new PropertyChangeSupport(this);
	private transient VetoableChangeSupport vetoableChangeListeners = new VetoableChangeSupport(this);
	
	private int blueColor;

	public ConstrainedTest()
	{
		this.addVetoableChangeListener(this);
	}

	public int getBlueColor()
	{
		return blueColor;
	}

	public void setBlueColor(int newBlueColor) throws java.beans.PropertyVetoException
	{
		int oldBlueColor = blueColor;
		vetoableChangeListeners.fireVetoableChange("blueColor", new Integer(oldBlueColor), new Integer(newBlueColor));
		blueColor = newBlueColor;
		propertyChangeListeners.firePropertyChange("blueColor", new Integer(oldBlueColor), new Integer(newBlueColor));
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l)
	{
		propertyChangeListeners.removePropertyChangeListener(l);
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l)
	{
		propertyChangeListeners.addPropertyChangeListener(l);
	}

	public synchronized void removeVetoableChangeListener(VetoableChangeListener l)
	{
		vetoableChangeListeners.removeVetoableChangeListener(l);
	}

	public synchronized void addVetoableChangeListener(VetoableChangeListener l)
	{
		vetoableChangeListeners.addVetoableChangeListener(l);
	}

	public void paint(Graphics g)
	{
		g.setColor(new Color(0, 0, this.blueColor));
		g.fillOval(0, 0, getSize().width, getSize().height);
	}

	public void vetoableChange(PropertyChangeEvent evt) throws java.beans.PropertyVetoException
	{
		int v = ((Integer) evt.getNewValue()).intValue();
		if (v < 0)
			throw new PropertyVetoException("value must >= 0", evt);
		else if (v >= 255)
			throw new PropertyVetoException("value must <256", evt);
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(50, 25);
	}
}
