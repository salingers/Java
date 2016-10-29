package frank.java.chapter13;

/**
 * 生物 (测试用类)
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Creature implements Alive {
	
	public static String STATIC = "static on Creature";
	
	protected String label = "label on Creature";

	private int age;
	
	public Creature(int age) {
		this.age = age;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + 
			"[" + age + "]";
	}
}
