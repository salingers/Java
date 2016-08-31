

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.*;

public class ArrayList<E>
{
	private StampedLock lock = new StampedLock();
	private Object[] elems;
	private int next;

	public ArrayList(int capacity)
	{
		elems = new Object[capacity];
	}

	public ArrayList()
	{
		this(16);
	}

	public void add(E elem)
	{
		long stamp = lock.writeLock();

		try
		{
			if (next == elems.length)
			{
				elems = Arrays.copyOf(elems, elems.length * 2);
			}
			elems[next++] = elem;
		}
		finally
		{
			lock.unlockWrite(stamp);
		}
	}

	public E get(int index)
	{
		long stamp = lock.tryOptimisticRead();
		Object elem = elems[index];
		if (!lock.validate(stamp))
		{
			stamp = lock.readLock();
			try
			{
				elem = elems[index];
			}
			finally
			{
				lock.unlockRead(stamp);
			}
		}
		return (E) elem;
	}

	public int size()
	{
		long stamp = lock.tryOptimisticRead();
		int size = next;
		if (!lock.validate(stamp))
		{
			stamp = lock.readLock();
			try
			{
				size = next;
			}
			finally
			{
				lock.unlockRead(stamp);
			}
		}
		return size;
	}

	public E[] toArray()
	{
		E[] elements = null;
		if (size() > 0)
		{
			elements = (E[]) Array.newInstance(elems[0].getClass(), size());
			for (int i = 0; i < elements.length; i++)
			{
				elements[i] = (E) elems[i];
			}
		}
		return elements;
	}
}
