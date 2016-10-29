package frank.java.chapter07.adapter;

/**
 * 这是一块 Intel 的主板，它只能使用 Intel 的 CPU<br>
 * 它代表了 Adapter 模式中的 Client
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
public class IntelMainborad {

	private Intel cpu;

	/** 该方法代表了开机动作 */
	public void start() {
		cpu.power();
	}

	public Intel getCpu() {
		return cpu;
	}

	public void setCpu(Intel cpu) {
		this.cpu = cpu;
	}

}
