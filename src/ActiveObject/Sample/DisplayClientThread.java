package ActiveObject.Sample;

import ActiveObject.Sample.activeobject.ActiveObject;
import ActiveObject.Sample.activeobject.Result;

public class DisplayClientThread extends Thread
{
	private final ActiveObject activeObject;

	public DisplayClientThread(String name, ActiveObject activeObject)
	{
		super(name);
		this.activeObject = activeObject;
	}

	public void run()
	{
		try
		{
			for (int i = 0; true; i++)
			{
				// 沒有傳回值的呼叫
				String string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		}
		catch (InterruptedException e)
		{
		}
	}
}
