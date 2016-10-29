package frank.java.chapter07.adapter;

/**
 * ��瘚����
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class AdapterTest {

	public static void main(String[] args) {
		IntelMainborad mainborad = new IntelMainborad();
		AMD amd = new Phenom2();
		AMD2IntelAdapter adapter = new AMD2IntelAdapter();
		adapter.setAmd(amd);
		mainborad.setCpu(adapter);
		mainborad.start();
	}

}
