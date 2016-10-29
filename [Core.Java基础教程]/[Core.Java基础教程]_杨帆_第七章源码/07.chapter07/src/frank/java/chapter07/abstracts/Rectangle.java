package frank.java.chapter07.abstracts;

/**
 * 矩形的柱子
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Rectangle extends Column {
	
	/** 长度 */
	private double length;
	/** 宽度 */
	private double width;

	public Rectangle(double length, double width, double height) {
		super(height);
		this.length = length;
		this.width = width;
	}

	@Override
	public double getArea() {
		return length * width;
	}

}
