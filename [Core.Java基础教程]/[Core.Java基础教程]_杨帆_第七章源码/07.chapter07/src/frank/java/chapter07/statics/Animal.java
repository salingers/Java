package frank.java.chapter07.statics;

public class Animal {

	static { // ���誨����
		System.out.println("Animal����誨����");
	}
	{ // ��誨����
		System.out.println("Animal���誨����");
	}

	private String name;

	public Animal() {
		System.out.println("Animal���恕���");
	}

	public Animal(String name) {
		System.out.println("Animal������");
	}

	public String getName() {
		return name;
	}

}
