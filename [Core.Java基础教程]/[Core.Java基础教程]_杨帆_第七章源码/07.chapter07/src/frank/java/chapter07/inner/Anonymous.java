package frank.java.chapter07.inner;

/**
 * 匿名内部类范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Anonymous {

	public static void main(String[] args) {
		String string = "Frank";
		executeCommand(string, new Command() {
			@Override
			public void execute(Object obj) {
				System.out.println(obj);
			}
		});
	}
	
	public static void executeCommand(Object arg, Command command) {
		command.execute(arg);
	}

}

interface Command {
	void execute(Object obj);
}
