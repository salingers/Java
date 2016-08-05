// Noninstantiable utility class
package org.effectivejava.examples;

public class UtilityClass
{
	// Suppress default constructor for noninstantiability
	private UtilityClass()
	{
		throw new AssertionError();
	}
}
