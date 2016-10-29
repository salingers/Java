package frank.java.chapter13.beanutils;

public class Address {

	private String code;
	private String detail;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Address [code=" + code + ", detail=" + detail + "]";
	}

}
