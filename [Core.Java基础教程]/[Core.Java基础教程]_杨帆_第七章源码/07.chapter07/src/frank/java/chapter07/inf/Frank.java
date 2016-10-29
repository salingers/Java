package frank.java.chapter07.inf;

import frank.java.chapter07.inheritance.Person;

public class Frank extends Person implements ITeacher, IStudent {

	public void teach() {
		System.out.println(getName() + "在教书！");
	}

	public void study() {
		System.out.println(getName() + "在学习！");
	}
	
	public static void main(String[] args) {
		Frank frank = new Frank();
		frank.setName("frank");
		frank.eat();
		frank.sleep();
		frank.teach();
		frank.study();
	}
}
