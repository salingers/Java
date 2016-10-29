package frank.java.chapter13.proxy;

import java.util.Random;

/**
 * 屠夫对象，代表了 RealSubject
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Butcher implements Bazaar {

	private Random random = new Random();
	
	@Override
	public boolean buyPork() {
		// 随机卖给你灌水猪肉
		if (random.nextInt() % 2 == 0)
			return true;
		return false;
	}

}
