package frank.java.chapter13.anno.demo;

public class AccountDao implements IAccountDao {

	@Override
	public void create(Account account) {
		System.out.println("创建用户");
	}

	@Override
	public void delete(String name) {
		System.out.println("删除用户");
	}

	@Override
	public void update(Account account) {
		System.out.println("更新用户");
	}

	@Override
	public Account load(String name) {
		System.out.println("读取用户");
		Account result = new Account();
		result.setName(name);
		return result;
	}

	@Override
	public void createAndUpdate(Account... accounts) {
		System.out.println("创建并更新用户");
	}

}
