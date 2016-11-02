package com.hackbulgaria.corejava.crawler.no;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AtomicSet implements Set<URI>
{

	@Override
	public String toString()
	{
		return handle.toString();
	}

	private Set<URI> handle = Collections.synchronizedSet(new HashSet<URI>());

	public int size()
	{
		return handle.size();
	}

	public boolean isEmpty()
	{
		return handle.isEmpty();
	}

	public boolean contains(Object o)
	{
		synchronized (this)
		{
			boolean result = handle.contains(o);
			if (!result)
			{
				if (!(o instanceof URI))
				{
					throw new RuntimeException(o.getClass().toString());
				}
				if (!handle.add((URI) o))
				{
					throw new RuntimeException("Element not added: " + o);
				}
				;
			}
			return result;
		}
	}

	public Iterator<URI> iterator()
	{
		return handle.iterator();
	}

	public Object[] toArray()
	{
		return handle.toArray();
	}

	public <T> T[] toArray(T[] a)
	{
		return handle.toArray(a);
	}

	public boolean add(URI e)
	{
		return handle.add(e);
	}

	public boolean remove(Object o)
	{
		return handle.remove(o);
	}

	public boolean containsAll(Collection<?> c)
	{
		return handle.containsAll(c);
	}

	public boolean addAll(Collection<? extends URI> c)
	{
		return handle.addAll(c);
	}

	public boolean retainAll(Collection<?> c)
	{
		return handle.retainAll(c);
	}

	public boolean removeAll(Collection<?> c)
	{
		return handle.removeAll(c);
	}

	public void clear()
	{
		handle.clear();
	}

}
