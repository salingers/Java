package frank.java.chapter11.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 线程阻塞的范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class BlockingDemo {

	public static void main(String[] args) throws IOException {
		System.out.println("主线程正在运行！");
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("主线程开始等待用户输入(进入阻塞)");
		String s = reader.readLine(); // 当执行该方法时，主线程进入阻塞状态
		System.out.println("收到用户输入(回到运行状态):" + s);
		
		System.out.println("主线程结束！");
	}

}
