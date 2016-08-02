package Mediator.Sample;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator
{
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;

	// 建構子
	// 產生並配置好Colleague之後再輸出到畫面上
	public LoginFrame(String title)
	{
		super(title);
		setBackground(Color.lightGray);
		// 使用頁面編排，產生4×2的畫面
		setLayout(new GridLayout(4, 2));
		// 使用頁面編排，產生4×2的畫面
		createColleagues();
		// 配置
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// 有效／無效的初始設定
		colleagueChanged();
		// 輸出到畫面上
		pack();
		show();
	}

	// 產生Colleague
	public void createColleagues()
	{
		// 產生
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// Mediator的部分
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listener的部分
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// 根據Colleague的通知，判斷各Colleague的有效／無效
	public void colleagueChanged()
	{
		if (checkGuest.getState())
		{ // Guest mode
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		}
		else
		{ // Login mode
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}

	// textUser或textPass有變動
	// 判斷各Colleague的有效／無效
	private void userpassChanged()
	{
		if (textUser.getText().length() > 0)
		{
			textPass.setColleagueEnabled(true);
			if (textPass.getText().length() > 0)
			{
				buttonOk.setColleagueEnabled(true);
			}
			else
			{
				buttonOk.setColleagueEnabled(false);
			}
		}
		else
		{
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.toString());
		System.exit(0);
	}
}
