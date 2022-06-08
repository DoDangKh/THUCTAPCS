package Entity;

public class NGANHANG {
	private String manh;
	private String tennh;
	public String getManh() {
		return manh;
	}
	public void setManh(String manh) {
		this.manh = manh;
	}
	public String getTennh() {
		return tennh;
	}
	public void setTennh(String tennh) {
		this.tennh = tennh;
	}
	public NGANHANG(String manh, String tennh) {
		super();
		this.manh = manh;
		this.tennh = tennh;
	}
	public NGANHANG() {
		super();
	}
	
}
