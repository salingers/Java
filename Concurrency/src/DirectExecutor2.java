

import java.util.concurrent.Executor;

public class DirectExecutor2 implements Executor
{
	public void execute(Runnable r)
	{
		r.run();
	}
}
