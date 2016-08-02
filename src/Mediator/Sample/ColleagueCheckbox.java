package Mediator.Sample;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague
{
	private Mediator mediator;

	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state)
	{ // �غc�l
		super(caption, group, state);
	}

	public void setMediator(Mediator mediator)
	{ // �O�dMediator
		this.mediator = mediator;
	}

	public void setColleagueEnabled(boolean enabled)
	{ // Mediator���ܦ��ġ��L��
		setEnabled(enabled);
	}

	public void itemStateChanged(ItemEvent e)
	{ // �Y���A���ܡA�q��Mediator
		mediator.colleagueChanged();
	}
}
