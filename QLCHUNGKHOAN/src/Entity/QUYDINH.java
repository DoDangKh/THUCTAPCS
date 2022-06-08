package Entity;

public class QUYDINH {
	private String maqd;
	private String mota;
	public String getMaqd() {
		return maqd;
	}
	public void setMaqd(String maqd) {
		this.maqd = maqd;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public QUYDINH(String maqd, String mota) {
		super();
		this.maqd = maqd;
		this.mota = mota;
	}
	public QUYDINH() {
		super();
	}
	
}
