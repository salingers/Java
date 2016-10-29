package frank.java.chapter07.inheritance;

public class Person {

	private String name;
	private boolean sex;
	private int age;

	public void eat() {
		System.out.println(name + "在吃饭！");
	}
	
	public void sleep() {
		System.out.println(name + "在睡觉！");
	}
	
	// Getter and Setter...
	
	public String getName() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
