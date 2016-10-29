package frank.java.chapter13.proxy;

/**
 * 卖放心肉的市场，代表了 Proxy
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class Market implements Bazaar {

	private Bazaar bazaar;

	public Bazaar getBazaar() {
		return bazaar;
	}

	public void setBazaar(Bazaar bazaar) {
		this.bazaar = bazaar;
	}

	@Override
	public boolean buyPork() {
		if (bazaar == null)
			bazaar = new Butcher();
		boolean result = false;
		while (!result)
			result = bazaar.buyPork();
		return result;
	}

}
