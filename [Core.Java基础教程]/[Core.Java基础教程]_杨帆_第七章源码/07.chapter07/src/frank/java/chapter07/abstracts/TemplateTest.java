package frank.java.chapter07.abstracts;

/**
 * 模板模式测试范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class TemplateTest {

	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(10.0, 5.0, 50.0);
		System.out.println("方柱的体积为:" + rectangle.getVolume());
		
		Round round = new Round(4.0, 50.0);
		System.out.println("圆柱的体积为:" + round.getVolume());
	}

}
