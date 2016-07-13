
import java.util.*;

public class ValueChangeEvent extends EventObject
{
	private int value;

	public int getValue()
	{
		return value;
	}

	public ValueChangeEvent(Object o, int v)
	{
		super(o);
		value = v;
	}
}