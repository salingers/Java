
package util.concurrent;

import java.util.concurrent.*;
import static java.lang.System.*;

public class FutureCallableDemo
{
	static long fibonacci(long n)
	{
		if (n <= 1)
		{
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) throws Exception
	{
		FutureTask<Long> the30thFibFuture = new FutureTask<>(() -> fibonacci(30));

		out.println("�����洵 30 �祥撘嚗���...");

		new Thread(the30thFibFuture).start();
		
		while (!the30thFibFuture.isDone())
		{
			out.println("敹���...");
		}

		out.printf("蝚� 30 �祥撘嚗�%d%n", the30thFibFuture.get());
	}
}
