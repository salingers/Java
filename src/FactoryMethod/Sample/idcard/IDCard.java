package FactoryMethod.Sample.idcard;

import FactoryMethod.Sample.framework.Product;

public class IDCard extends Product
{
	private String owner;

	IDCard(String owner)
	{
		System.out.println("�إ�" + owner + "���d�C");
		this.owner = owner;
	}

	public void use()
	{
		System.out.println("�ϥ�" + owner + "���d�C");
	}

	public String getOwner()
	{
		return owner;
	}
}
