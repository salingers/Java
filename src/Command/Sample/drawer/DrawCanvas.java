package Command.Sample.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import Command.Sample.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable
{
	// ø�s��m
	private Color color = Color.red;
	// ø�s�I���b�|
	private int radius = 6;
	// �O��
	private MacroCommand history;

	// �غc�l
	public DrawCanvas(int width, int height, MacroCommand history)
	{
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	// �A��ø�s��ӰO��
	public void paint(Graphics g)
	{
		history.execute();
	}

	// ø�s
	public void draw(int x, int y)
	{
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}
