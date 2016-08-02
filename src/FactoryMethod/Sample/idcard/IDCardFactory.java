package FactoryMethod.Sample.idcard;

import java.util.ArrayList;
import java.util.List;

import FactoryMethod.Sample.framework.Factory;
import FactoryMethod.Sample.framework.Product;

public class IDCardFactory extends Factory
{
	private List owners = new ArrayList();

	protected Product createProduct(String owner)
	{
		return new IDCard(owner);
	}

	protected void registerProduct(Product product)
	{
		owners.add(((IDCard) product).getOwner());
	}

	public List getOwners()
	{
		return owners;
	}
}
