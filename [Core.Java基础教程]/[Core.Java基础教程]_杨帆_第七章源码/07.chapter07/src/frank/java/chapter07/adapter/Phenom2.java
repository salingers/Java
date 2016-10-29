package frank.java.chapter07.adapter;

/**
 * AMD Phenom II CPU
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Phenom2 implements AMD {
	
	@Override
	public void ac() {
		System.out.println("AMD Phenom II 在工作!");
	}

}
