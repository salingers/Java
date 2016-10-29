package frank.java.chapter13.proxy;

/**
 * Proxy 模式范例测试
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class ProxyTest {

	public static void main(String[] args) {

		Bazaar bazaar = new Market();
		// Bazaar bazaar = new Butcher();

		for (int i = 0; i < 10; i++) {
			if (bazaar.buyPork())
				System.out.println(i + ":买到放心肉了");
			else
				System.out.println(i + ":买到灌水肉了");
		}

	}

}
