package frank.java.chapter13.anno.demo;

@Dao(AccountDao.class)
public interface IAccountDao
{

	@Permission(PermissionValue.CREATE) // 0010
	void create(Account account);

	@Permission(PermissionValue.DELETE) // 1000
	void delete(String name);

	@Permission(PermissionValue.UPDATE) // 0100
	void update(Account account);

	@Permission(PermissionValue.READ) // 0001
	Account load(String name);

	@Permission(PermissionValue.CREATE + PermissionValue.UPDATE) // 0011
	void createAndUpdate(Account... accounts);
}
