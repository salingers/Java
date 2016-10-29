package frank.java.chapter07.adapter;

/**
 * 将 AMD CPU 转为 Intel CPU 的适配器
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class AMD2IntelAdapter implements Intel {

	private AMD amd;

	@Override
	public void power() {
		amd.ac();
	}

	// Getter and Setter...
	
	public AMD getAmd() {
		return amd;
	}

	public void setAmd(AMD amd) {
		this.amd = amd;
	}

}
