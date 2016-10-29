package frank.java.chapter13.anno.demo;

public enum Context {
	
	INSTANCE;
	
	private ThreadLocal<Integer> permission = new ThreadLocal<Integer>();
	
	public void setCurrentPermission(int mask) {
		permission.set(mask);
	}

	public int getCurrentPermission() {
		return permission.get();
	}

}
