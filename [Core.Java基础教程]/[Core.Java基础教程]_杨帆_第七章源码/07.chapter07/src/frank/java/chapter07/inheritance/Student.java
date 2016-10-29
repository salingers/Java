package frank.java.chapter07.inheritance;

public class Student extends Person {

	private String code;

	public void study() {
		System.out.println(this.getName() + "在学习！");
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
