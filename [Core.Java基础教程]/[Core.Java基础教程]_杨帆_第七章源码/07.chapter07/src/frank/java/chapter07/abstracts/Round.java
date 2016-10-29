package frank.java.chapter07.abstracts;

/**
 * 圆形的柱子
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Round extends Column {
	/** 半径 */
	private double radius;

	public Round(double radius, double height) {
		super(height);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
