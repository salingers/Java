package frank.java.chapter11.lock;

/**
 * 自定义堆栈范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class MyStack {

	private int idx = 0;
	private char[] data = new char[6];
	
	public void push(char c) {
		synchronized (this) {
			data[idx] = c;
			idx++;
		}
	}	

	public char pop() {
		synchronized (this) {
			idx--;
			return data[idx];
		}
	}
}
