package frank.java.chapter07.abstracts;

/**
 * 柱子<br>
 * 抽象类范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public abstract class Column {

	/** 高度属性 */
	protected double height;
	
	public Column(double height) {
		this.height = height;
	}
	
	/**
	 * 获取 底面积
	 * @return
	 */
	public abstract double getArea();
	
	/**
	 * 获取 体积
	 * @return
	 */
	public double getVolume() {
		return getArea() * height;
	}
	
}
