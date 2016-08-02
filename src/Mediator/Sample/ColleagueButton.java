package Mediator.Sample;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague
{
	private Mediator mediator;

	public ColleagueButton(String caption)
	{
		super(caption);
	}

	public void setMediator(Mediator mediator)
	{ // �O�dMediator
		this.mediator = mediator;
	}

	public void setColleagueEnabled(boolean enabled)
	{ // Mediator���ܦ��ġ��L��
		setEnabled(enabled);
	}
}
