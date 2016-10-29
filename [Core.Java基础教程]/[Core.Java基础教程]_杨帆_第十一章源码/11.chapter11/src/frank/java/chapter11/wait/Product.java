package frank.java.chapter11.wait;

/**
 * 产品对象
 * @author Frank
 */
public class Product {
	
	private String code;
	
	public Product(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
