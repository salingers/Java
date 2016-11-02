package frank.java.chapter13.anno.demo;

public class AccountDao implements IAccountDao
{

	@Override
	public void create(Account account)
	{
		System.out.println("��遣��");
	}

	@Override
	public void delete(String name)
	{
		System.out.println("����");
	}

	@Override
	public void update(Account account)
	{
		System.out.println("����");
	}

	@Override
	public Account load(String name)
	{
		System.out.println("霂餃��");
		Account result = new Account();
		result.setName(name);
		return result;
	}

	@Override
	public void createAndUpdate(Account... accounts)
	{
		System.out.println("��遣撟嗆���");
	}

}
