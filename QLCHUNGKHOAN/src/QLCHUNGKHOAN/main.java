package QLCHUNGKHOAN;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(IsDbExist.check()) {
		//KetNoiDB.LayKetNoi("sa","123456");
		FromDangNhap frm=new FromDangNhap();
		frm.setVisible(true);
		}
		else {
		Recovery frm=new Recovery();
		frm.setVisible(true);
		}
	}

}
