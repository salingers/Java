package frank.java.chapter13.beanutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherObject {

	private String[] array = { "one", "two", "three" };
	private List<Integer> list = new ArrayList<Integer>();
	private Map<String, Double> map = new HashMap<String, Double>();

	{
		Collections.addAll(list, 1, 2, 3);
		map.put("one", 1.0);
		map.put("two", 2.0);
		map.put("three", 3.0);
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Map<String, Double> getMap() {
		return map;
	}

	public void setMap(Map<String, Double> map) {
		this.map = map;
	}

}
