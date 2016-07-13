import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class ExDTFmt extends Frame implements ActionListener, ItemListener
{
		private Locale[] locales;
		private Date currentDate;
		private Date currentTime;
		private DateFormat currentDateFormat;
		private DateFormat currentTimeFormat;
		private Choice localeChoice = new Choice();
		private EnumChoice dateStyleChoice = new EnumChoice(DateFormat.class, new String[]
		{ "Default", "Full", "Long", "Medium", "Short" });
		private EnumChoice timeStyleChoice = new EnumChoice(DateFormat.class, new String[]
		{ "Default", "Full", "Long", "Medium", "Short" });
		private Button dateParseButton = new Button("日期轉換");
		private Button timeParseButton = new Button("時間轉換");
		private TextField dateText = new TextField(30);
		private TextField timeText = new TextField(30);
		private TextField parseText = new TextField(30);
		private Checkbox lenientCheckbox = new Checkbox("轉換修正", true);

		public ExDTFmt()
		{
				setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.NONE;
				gbc.anchor = GridBagConstraints.EAST;
				add(new Label("國家語言"), gbc, 0, 0, 1, 1);
				add(new Label("日期型態"), gbc, 0, 1, 1, 1);
				add(new Label("時間型態"), gbc, 2, 1, 1, 1);
				add(new Label("日期"), gbc, 0, 2, 1, 1);
				add(new Label("時間"), gbc, 0, 3, 1, 1);
				gbc.anchor = GridBagConstraints.WEST;
				add(localeChoice, gbc, 1, 0, 2, 1);
				add(dateStyleChoice, gbc, 1, 1, 1, 1);
				add(timeStyleChoice, gbc, 3, 1, 1, 1);
				add(dateText, gbc, 1, 2, 2, 1);
				add(dateParseButton, gbc, 3, 2, 1, 1);
				add(timeText, gbc, 1, 3, 2, 1);
				add(timeParseButton, gbc, 3, 3, 1, 1);
				add(lenientCheckbox, gbc, 0, 4, 2, 1);
				locales = DateFormat.getAvailableLocales();
				for (int i = 0; i < locales.length; i++)
						localeChoice.add(locales[i].getDisplayName());
				localeChoice.select(Locale.getDefault().getDisplayName());
				currentDate = new Date();
				currentTime = new Date();
				updateDisplay();
				localeChoice.addItemListener(this);
				dateStyleChoice.addItemListener(this);
				timeStyleChoice.addItemListener(this);
				dateParseButton.addActionListener(this);
				timeParseButton.addActionListener(this);
				addWindowListener(new WindowAdapter() // 視窗關閉事件
				{
						public void windowClosing(WindowEvent e)
						{
								dispose();
								System.exit(0);
						}
				});
		}

		public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
		{
				gbc.gridx = x;
				gbc.gridy = y;
				gbc.gridwidth = w;
				gbc.gridheight = h;
				add(c, gbc);
		}

		public void actionPerformed(ActionEvent evt)
		{
				if (evt.getSource() == dateParseButton)
				{
						String d = dateText.getText();
						try
						{
								currentDateFormat.setLenient(lenientCheckbox.getState());
								Date date = currentDateFormat.parse(d);
								currentDate = date;
								updateDisplay();
						} catch (ParseException e)
						{
								dateText.setText("Parse error:" + d);
						} catch (IllegalArgumentException e)
						{
								dateText.setText("Argument error:" + d);
						}
				} else if (evt.getSource() == timeParseButton)
				{
						String t = timeText.getText();
						try
						{
								currentDateFormat.setLenient(lenientCheckbox.getState());
								Date date = currentTimeFormat.parse(t);
								currentTime = date;
								updateDisplay();
						} catch (ParseException e)
						{
								timeText.setText("Parse error:" + t);
						} catch (IllegalArgumentException e)
						{
								timeText.setText("Argument error:" + t);
						}
				}
		}

		public void itemStateChanged(ItemEvent evt)
		{
				if (evt.getSource() instanceof Choice)
				{
						if (evt.getStateChange() == ItemEvent.SELECTED)
								updateDisplay();
				}
		}

		public void updateDisplay()
		{
				Locale currentLocale = locales[localeChoice.getSelectedIndex()];
				int dateStyle = dateStyleChoice.getValue();
				currentDateFormat = DateFormat.getDateInstance(dateStyle, currentLocale);
				String d = currentDateFormat.format(currentDate);
				dateText.setText(d);
				int timeStyle = timeStyleChoice.getValue();
				currentTimeFormat = DateFormat.getTimeInstance(timeStyle, currentLocale);
				String t = currentTimeFormat.format(currentTime);
				timeText.setText(t);
		}

		public static void main(String[] args)
		{
				Frame f = new ExDTFmt();
				f.setTitle("日期與時間之國際化");
				f.setSize(400, 200);
				f.show();
		}
}

class EnumChoice extends Choice
{
		public EnumChoice(Class cl, String[] labels)
		{
				for (int i = 0; i < labels.length; i++)
				{
						String label = labels[i];
						String name = label.toUpperCase().replace(' ', '_');
						int value = 0;
						try
						{
								java.lang.reflect.Field f = cl.getField(name);
								value = f.getInt(cl);
						} catch (Exception e)
						{
								label = "(" + label + ")";
						}
						table.put(label, new Integer(value));
						add(label);
				}
				select(labels[0]);
		}

		public int getValue()
		{
				return ((Integer) table.get(getSelectedItem())).intValue();
		}

		private Hashtable table = new Hashtable();
}
