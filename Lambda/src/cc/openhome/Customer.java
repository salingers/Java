package cc.openhome;

public class Customer
{


	private String firstName;
	private String lastName;
	private Integer zipCode;

	public Customer(String firstName, String lastName, Integer zipCode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
	}

	public Customer(String firstName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
	}

	public String toString()
	{
		return String.format("Customer(%s %s, %d)", firstName, lastName, zipCode);
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setZipCode(Integer zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public Integer getZipCode()
	{
		return zipCode;
	}
}
