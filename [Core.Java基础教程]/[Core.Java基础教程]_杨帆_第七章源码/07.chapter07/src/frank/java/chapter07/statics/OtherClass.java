package frank.java.chapter07.statics;

/**
 * 公开类属性测试范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class OtherClass {

	public static void main(String[] args) {
		OnlineUser.count++;
		System.out.println(OnlineUser.count);
	}

}
