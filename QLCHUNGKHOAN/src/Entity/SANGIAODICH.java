package Entity;

public class SANGIAODICH {
	private String masan;
	private String tensan;
	public String getMasan() {
		return masan;
	}
	public void setMasan(String masan) {
		this.masan = masan;
	}
	public String getTensan() {
		return tensan;
	}
	public void setTensan(String tensan) {
		this.tensan = tensan;
	}
	public SANGIAODICH(String masan, String tensan) {
		super();
		this.masan = masan;
		this.tensan = tensan;
	}
	public SANGIAODICH() {
		super();
	}
	public SANGIAODICH(String masan) {
		super();
		this.masan = masan;
	}
}
