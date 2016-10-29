package frank.java.chapter11.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList 使用范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
		Collections.addAll(list, "one", "two", "three");
		for (String s : list) {
			System.out.println(s);
			list.add("new");
		}
	}

}
