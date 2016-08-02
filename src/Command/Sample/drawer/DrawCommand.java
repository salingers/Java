package Command.Sample.drawer;

import java.awt.Point;

public class DrawCommand implements Command.Sample.command.Command
{
	// ø�s��H
	protected Drawable drawable;
	// ø�s��m
	private Point position;

	// �غc�l
	public DrawCommand(Drawable drawable, Point position)
	{
		this.drawable = drawable;
		this.position = position;
	}

	// ����
	public void execute()
	{
		drawable.draw(position.x, position.y);
	}
}
