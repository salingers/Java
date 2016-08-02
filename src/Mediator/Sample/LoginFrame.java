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

	// �غc�l
	// ���ͨðt�m�nColleague����A��X��e���W
	public LoginFrame(String title)
	{
		super(title);
		setBackground(Color.lightGray);
		// �ϥέ����s�ơA����4��2���e��
		setLayout(new GridLayout(4, 2));
		// �ϥέ����s�ơA����4��2���e��
		createColleagues();
		// �t�m
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		// ���ġ��L�Ī���l�]�w
		colleagueChanged();
		// ��X��e���W
		pack();
		show();
	}

	// ����Colleague
	public void createColleagues()
	{
		// ����
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		// Mediator������
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		// Listener������
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// �ھ�Colleague���q���A�P�_�UColleague�����ġ��L��
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

	// textUser��textPass���ܰ�
	// �P�_�UColleague�����ġ��L��
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