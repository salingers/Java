package frank.java.chapter07.statics;

/**
 * 类属性初始化范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class InitField {
	
	static int number;
	static User userOne = initUser();
	static User userTwo;
	
	static {
		System.out.println("static");
		User user = new User();
		user.setName("May");
		userTwo = user;
	}

	private static User initUser() {
		System.out.println("initUser");
		User result = new User();
		result.setName("frank");
		return result;
	}
}
