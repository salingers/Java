

import java.awt.*;
import java.beans.*;
import java.io.Serializable;

public class BasicCustomer extends Panel implements Serializable{
  private String text="TEXT";
  private transient PropertyChangeSupport propertyChangeListeners = new PropertyChangeSupport(this);
  private int style=0;
  private Font font;
  private java.awt.Color textColor;

  public BasicCustomer() {
   font=new Font("細明體",Font.PLAIN,16);
  }

  public String getText() {
    return text;
  }

  public void resetFont() {
   switch(style) {
    case 0:
      font=new Font("細明體",Font.PLAIN,16);
     break;
    case 1:
      font=new Font("細明體",Font.BOLD,16);
     break;
    case 2:
      font=new Font("細明體",Font.ITALIC,16);
     break;
    case 3:
      font=new Font("細明體",Font.BOLD+Font.ITALIC,16);
     break;
   }
  }

  public void setText(String newText) {
    String  oldText = text;
    text = newText;
    propertyChangeListeners.firePropertyChange("text", oldText, newText);
  }

  public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
    propertyChangeListeners.removePropertyChangeListener(l);
  }

  public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
    propertyChangeListeners.addPropertyChangeListener(l);
  }

  public void setStyle(int newStyle) {
    int  oldStyle = style;
    style = newStyle;
    propertyChangeListeners.firePropertyChange("style", new Integer(oldStyle), new Integer(newStyle));
    resetFont();
  }

  public int getStyle() {
    return style;
  }

  public void setTextColor(java.awt.Color newTextColor) {
    textColor = newTextColor;
  }

  public java.awt.Color getTextColor() {
    return textColor;
  }

  public void paint(Graphics g) {
    g.setFont(font);
    g.setColor(textColor);

    FontMetrics fm=g.getFontMetrics(font);

    int swidth=fm.stringWidth(text);
    int sheight=fm.getHeight();
    g.draw3DRect(0,0,getSize().width-1,getSize().height-1,true);
    g.drawString(text,(getSize().width-swidth)/2,
                      (getSize().height+sheight)/2);
  }
}

