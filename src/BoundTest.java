
import java.awt.*;
import java.beans.*;

public class BoundTest extends Canvas
{
	private java.awt.Color showColor = Color.red;
	
	private transient PropertyChangeSupport propertyChangeListeners = new PropertyChangeSupport(this);

	public BoundTest()
	{
	}

	public java.awt.Color getShowColor()
	{
		return showColor;
	}

	public void setShowColor(java.awt.Color newShowColor)
	{
		java.awt.Color oldShowColor = showColor;
		showColor = newShowColor;
		propertyChangeListeners.firePropertyChange("showColor", oldShowColor, newShowColor);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l)
	{
		propertyChangeListeners.removePropertyChangeListener(l);
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l)
	{
		propertyChangeListeners.addPropertyChangeListener(l);
	}

	public void paint(Graphics g)
	{
		g.setColor(this.showColor);
		g.fillRoundRect(0, 0, getSize().width, getSize().height, 5, 5);
	}
}
