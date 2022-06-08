package Entity;

public class COPHIEU {
	private String macp;
	private String masan;
	private String tencty;
	private String diachi;
	private String sdt;
	private String fax;
	private String diachiweb;
	private String email;
	private int slcp;
	
	public COPHIEU() {
		super();
	}
	public COPHIEU(String macp, String masan, String tencty, String diachi, String sdt, String fax, String diachiweb,
			String email, int slcp) {
		super();
		this.macp = macp;
		this.masan = masan;
		this.tencty = tencty;
		this.diachi = diachi;
		this.sdt = sdt;
		this.fax = fax;
		this.diachiweb = diachiweb;
		this.email = email;
		this.slcp = slcp;
	}
	public String getMacp() {
		return macp;
	}
	public void setMacp(String macp) {
		this.macp = macp;
	}
	public String getMasan() {
		return masan;
	}
	public void setMasan(String masan) {
		this.masan = masan;
	}
	public String getTencty() {
		return tencty;
	}
	public void setTencty(String tencty) {
		this.tencty = tencty;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getDiachiweb() {
		return diachiweb;
	}
	public void setDiachiweb(String diachiweb) {
		this.diachiweb = diachiweb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSlcp() {
		return slcp;
	}
	public void setSlcp(int slcp) {
		this.slcp = slcp;
	}
	
}
