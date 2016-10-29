package frank.java.chapter13.beanutils;

public class Teacher {

	private String name;
	private int age;
	private boolean sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Teacher [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}

}
