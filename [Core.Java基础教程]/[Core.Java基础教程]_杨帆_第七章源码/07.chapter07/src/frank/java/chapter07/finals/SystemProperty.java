package frank.java.chapter07.finals;

/**
 * 外部指定系统常量值范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class SystemProperty {
	
	public final static String globalName;

	static {
		globalName = System.getProperty("MyGlobalName");
		// 如果想通过系统的环境变量值进行赋值，可使用下面的方法
		// globalName = System.getenv("JAVA_HOME");
	}
	
	public static void main(String[] args) {
		System.out.println(SystemProperty.globalName);
	}
}
