package frank.java.chapter13.proxy.jdk.one;

public class UserManager implements IUserManager {

	@Override
	public void createUser(String name, String password, Boolean sex,
			Integer age) {
		System.out.println("创建用户了！");
	}

}
