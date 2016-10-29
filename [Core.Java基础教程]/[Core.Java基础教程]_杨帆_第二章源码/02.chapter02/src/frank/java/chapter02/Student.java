package frank.java.chapter02;

/**
 * 学生类范例<br/>
 * 该类用来说明Java注释与Java doc
 * <pre>
 * Student frank = new Student("frank", 32, true);
 * </pre>
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Student {

	/**
	 * 姓名属性
	 * java.lang.String 叫字符串是Java的一个对象，它并不是基本数据类型。
	 * 这要和 char 区分开，char 是基本数据类型，它只能表示一个字符。
	 */
	protected String name;
	/* 年龄 */
	protected int age; // 年龄
	/* 性别 */
	protected boolean sex; // 性别

	/**
	 * 默认构造方法
	 * @param name 姓名
	 * @param age 年龄
	 * @param sex 性别 true:男 false:女
	 */
	public Student(String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	/**
	 * 获取 姓名
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 姓名
	 * @param name 姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 年龄
	 * @return 年龄
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置 年龄
	 * @param age 年龄
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 检查性别
	 * @return true:男 false:女
	 */
	public boolean isSex() {
		return sex;
	}

	/**
	 * 设置 性别
	 * @param sex true:男 false:女
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

}

