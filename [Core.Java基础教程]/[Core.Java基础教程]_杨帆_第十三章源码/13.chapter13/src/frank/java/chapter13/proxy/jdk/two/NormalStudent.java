package frank.java.chapter13.proxy.jdk.two;

public class NormalStudent implements Student {
	
	private String name;
	
	public NormalStudent(String name) {
		this.name = name;
	}

	@Override
	public void study() {
		System.out.println(name + "在学习!");
	}

	@Override
	public void fun() {
		System.out.println(name + "在玩!");
	}

}
