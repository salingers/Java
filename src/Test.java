
import java.awt.*;

public class Test extends Frame implements ValueChangeListener
{
		NewScrollBar nsb;
		Label lab;

		public Test()
		{
				nsb = new NewScrollBar();
				lab = new Label();
				nsb.addValueChangeListener(this);
				// nsb.addValueChangeListener(new ListenerObject());
				this.setLayout(new BorderLayout());
				this.add("South", lab);
				this.add("Center", nsb);
		}

		public static void main(String[] args)
		{
				Test test = new Test();
				test.setSize(300, 100);
				test.setVisible(true);
		}

		public void valueChanged(ValueChangeEvent vce)
		{
				lab.setText("²{¦bªº­È" + String.valueOf(vce.getValue()));
		}
}
/*
 * class ListenerObject implements ValueChangeListener {
 * 
 * public void valueChanged(ValueChangeEvent vce) {
 * System.out.println(vce.getValue()); } }
 */
