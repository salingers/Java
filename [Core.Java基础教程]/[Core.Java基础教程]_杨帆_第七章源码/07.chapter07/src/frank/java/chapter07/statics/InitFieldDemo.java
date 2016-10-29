package frank.java.chapter07.statics;

public class InitFieldDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("before");

		//Class clz = InitField.class;
		Class clz = Class.forName("frank.java.chapter07.statics.InitField", 
				true, InitFieldDemo.class.getClassLoader());
		
		System.out.println(InitField.number);
		System.out.println(InitField.userOne);
		System.out.println(InitField.userTwo);

		System.out.println(clz.getName());
		System.out.println("after");
	}

}
