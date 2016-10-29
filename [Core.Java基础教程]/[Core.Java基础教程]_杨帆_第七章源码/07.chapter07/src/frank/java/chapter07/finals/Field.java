package frank.java.chapter07.finals;

import frank.java.chapter07.statics.User;

/**
 * final 属性范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Field {

	private final int x = 100;
	private final User userOne;
	private final User userTwo;

	{
		userOne = new User();
		userOne.setName("frank");
	}

	public Field() {
		userTwo = new User();
		userTwo.setName("may");
	}

	public int getX() {
		return x;
	}

	public User getUserOne() {
		return userOne;
	}

	public User getUserTwo() {
		return userTwo;
	}

}
