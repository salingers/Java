import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Lister extends Applet
{
	private Listerpanel listerpanel = new Listerpanel(this);
	private Label l1 = new Label(" ", Label.CENTER);

	public void init()
	{
		setLayout(new BorderLayout());
		add(listerpanel, "North");
		add(l1, "Center");
	}

	public void start()
	{
		updateLabel(listerpanel.getSelectedFont());
	}

	public void updateLabel(Font font)
	{
		l1.setText("高雄師大Java實驗室");
		l1.setFont(font);
	}
}

class Listerpanel extends Panel
{
	private Lister lister;
	private List familyList = new List();

	public Listerpanel(Lister applet)
	{
		Listener listener = new Listener();
		lister = applet;
		populateFonts();
		add(familyList);
		familyList.addItemListener(listener);
		familyList.select(0);
	}

	public class Listener implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			lister.updateLabel(getSelectedFont());
		}
	}

	public Font getSelectedFont()
	{
		return new Font(familyList.getSelectedItem(), Font.PLAIN, 18);
	}

	private void populateFonts()
	{
		String fontNames[] = getToolkit().getFontList();
		for (int i = 0; i < fontNames.length; i++)
			familyList.add(fontNames[i]);
	}
}
