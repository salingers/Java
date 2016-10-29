package frank.java.chapter13;

/**
 * 人(测试用类)
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Human extends Creature {

	public String name;  // Field
	private boolean sex;

	public Human() { // Constructor
		super(0);
	}

	public Human(String name, int age) {
		super(age);
		this.name = name;
	}

	private Human(int age) {
		super(age);
	}

	public String getName() { // Method
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", sex=" + sex + ", age=" + this.getAge() + "]";
	}

}
