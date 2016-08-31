package cc.openhome;

import static java.lang.System.out;
import java.util.*;
import static java.util.Comparator.comparing;

public class CustomerDemo
{
	public static void main(String[] args)
	{
		List<Customer> customers = Arrays.asList(new Customer("Justin", "Lin", 804),
				new Customer("Monica", "Huang", 804), new Customer("Irene", "Lin", 804));

		Comparator<Customer> byLastName = comparing(Customer::getLastName);

		customers.sort(byLastName.thenComparing(Customer::getFirstName).thenComparing(Customer::getZipCode));

		customers.forEach(out::println);
	}
}