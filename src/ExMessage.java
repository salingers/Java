import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class ExMessage extends Applet implements ActionListener, ItemListener
{

		int save, now, saving, percent, year, Total;
		private Locale[] locales;
		private Label localeLabel = new Label("Language");
		private Label saveLabel = new Label("Principal");
		private Label nowLabel = new Label("Annum");
		private Label savingLabel = new Label("EachYearDeposit");
		private Label percentLabel = new Label("InterestRate");
		private Label yearLabel = new Label("BalanceYear");
		private Button moneyButton = new Button("Balance");
		private Choice localeChoice = new Choice();
		private TextField saveField = new TextField(20);
		private TextField nowField = new TextField(8);
		private TextField savingField = new TextField(20);
		private TextField percentField = new TextField(8);
		private TextField yearField = new TextField(8);
		private TextField moneyField = new TextField(20);
		private ResourceBundle res;
		Locale currentLocale;
		NumberFormat currencyFmt, numberFmt, percentFmt;

		public void init()
		{
				GridBagLayout gbl = new GridBagLayout();
				setLayout(gbl);
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.weightx = 100;
				gbc.weighty = 100;
				gbc.fill = GridBagConstraints.NONE;
				gbc.anchor = GridBagConstraints.WEST;

				add(localeLabel, gbc, 0, 0, 1, 1);
				localeChoice.addItemListener(this);
				add(localeChoice, gbc, 1, 0, 2, 1);

				add(saveLabel, gbc, 0, 1, 1, 1);
				add(saveField, gbc, 1, 1, 2, 1);

				add(nowLabel, gbc, 0, 2, 1, 1);
				add(nowField, gbc, 1, 2, 1, 1);

				add(savingLabel, gbc, 0, 3, 1, 1);
				add(savingField, gbc, 1, 3, 1, 1);

				add(percentLabel, gbc, 0, 4, 1, 1);
				add(percentField, gbc, 1, 4, 1, 1);

				add(yearLabel, gbc, 0, 5, 1, 1);
				add(yearField, gbc, 1, 5, 1, 1);

				Color white = new Color(255, 255, 255);
				moneyField.setBackground(white);
				moneyButton.addActionListener(this);
				add(moneyButton, gbc, 0, 6, 1, 1);
				add(moneyField, gbc, 1, 6, 1, 1);

				locales = new Locale[]
				{ Locale.US, Locale.TAIWAN, Locale.GERMANY };
				for (int i = 0; i < locales.length; i++)
						localeChoice.add(locales[i].getDisplayLanguage());
				localeChoice.select(0);
		}

		void setCurrentLocale()
		{
				currentLocale = locales[localeChoice.getSelectedIndex()];
				res = ResourceBundle.getBundle("ExMessageResource", currentLocale);
				currencyFmt = NumberFormat.getCurrencyInstance(currentLocale);
				numberFmt = NumberFormat.getNumberInstance(currentLocale);
				percentFmt = NumberFormat.getPercentInstance(currentLocale);
		}

		void updateField() throws ParseException
		{
				saveField.setText(currencyFmt.format(save));
				savingField.setText(currencyFmt.format(saving));
				nowField.setText(numberFmt.format(now));
				percentField.setText(percentFmt.format(percent));
		}

		void updateMessage()
		{
				localeLabel.setText(res.getString("Language"));
				saveLabel.setText(res.getString("Principal"));
				nowLabel.setText(res.getString("Annum"));
				savingLabel.setText(res.getString("EachYearDeposit"));
				percentLabel.setText(res.getString("InterestRate"));
				yearLabel.setText(res.getString("BalanceYear"));
				moneyButton.setLabel(res.getString("Balance"));
		}

		public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
		{
				gbc.gridx = x;
				gbc.gridy = y;
				gbc.gridwidth = w;
				gbc.gridheight = h;
				add(c, gbc);
		}

		public void itemStateChanged(ItemEvent e)
		{
				setCurrentLocale();
				updateMessage();
		}

		public void actionPerformed(ActionEvent evt)
		{
				save = Integer.parseInt(saveField.getText());
				now = Integer.parseInt(nowField.getText());
				saving = Integer.parseInt(savingField.getText());
				percent = Integer.parseInt(percentField.getText());
				year = Integer.parseInt(yearField.getText());
				Total = (save + (year - now - 1) * saving) * ((1 + (percent / 100)) ^ (year - now + 1));
				moneyField.setText(String.valueOf(Total));
				setCurrentLocale();
				try
				{
						updateField();
				} catch (ParseException e)
				{
				}
		}
}
