package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.NHANVIEN;
import Entity.QUYDINH;
import QLCHUNGKHOAN.KetNoiDB;

public class QUYDINHService {
	public static ArrayList<QUYDINH> loadQD(NHANVIEN nv)
	{
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(), nv.getMatkhau());
		Statement st=null;
		ArrayList<QUYDINH> ar=new ArrayList<>();
		try
		{
			st=ketnoi.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM QUYDINH");
			while(rs.next())
			{
				String maqd=rs.getString("MAQD");
				String mota=rs.getString("MOTA");
				QUYDINH qd=new QUYDINH(maqd, mota);
				ar.add(qd);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ar;
	}
}
