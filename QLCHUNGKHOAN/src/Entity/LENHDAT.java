package Entity;

public class LENHDAT {
	private String MALENH;
	private String MACP;
	private String MATKNH;
	private String LOAIGD;
	private String SLDAT;
	private String GIADAT;
	private String NGAYGIODAT;
	private String MATT;
	private String MALOAILENH;
	public LENHDAT(String mALENH, String mACP, String mATKNH, String lOAIGD, String sLDAT, String gIADAT,
			String nGAYGIODAT, String mATT, String mALOAILENH) {
		super();
		MALENH = mALENH;
		MACP = mACP;
		MATKNH = mATKNH;
		LOAIGD = lOAIGD;
		SLDAT = sLDAT;
		GIADAT = gIADAT;
		NGAYGIODAT = nGAYGIODAT;
		MATT = mATT;
		MALOAILENH = mALOAILENH;
	}
	public LENHDAT() {
		super();
	}
	public String getMALENH() {
		return MALENH;
	}
	public void setMALENH(String mALENH) {
		MALENH = mALENH;
	}
	public String getMACP() {
		return MACP;
	}
	public void setMACP(String mACP) {
		MACP = mACP;
	}
	public String getMATKNH() {
		return MATKNH;
	}
	public void setMATKNH(String mATKNH) {
		MATKNH = mATKNH;
	}
	public String getLOAIGD() {
		return LOAIGD;
	}
	public void setLOAIGD(String lOAIGD) {
		LOAIGD = lOAIGD;
	}
	public String getSLDAT() {
		return SLDAT;
	}
	public void setSLDAT(String sLDAT) {
		SLDAT = sLDAT;
	}
	public String getGIADAT() {
		return GIADAT;
	}
	public void setGIADAT(String gIADAT) {
		GIADAT = gIADAT;
	}
	public String getNGAYGIODAT() {
		return NGAYGIODAT;
	}
	public void setNGAYGIODAT(String nGAYGIODAT) {
		NGAYGIODAT = nGAYGIODAT;
	}
	public String getMATT() {
		return MATT;
	}
	public void setMATT(String mATT) {
		MATT = mATT;
	}
	public String getMALOAILENH() {
		return MALOAILENH;
	}
	public void setMALOAILENH(String mALOAILENH) {
		MALOAILENH = mALOAILENH;
	}
	
	
}
