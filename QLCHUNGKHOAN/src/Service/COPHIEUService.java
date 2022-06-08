package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.COPHIEU;
import Entity.NHANVIEN;
import QLCHUNGKHOAN.KetNoiDB;

public class COPHIEUService {
	public static ArrayList<COPHIEU> loadCP(NHANVIEN nv)
    {
        Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<COPHIEU> arr=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From COPHIEU");
            while(rs.next())
            {
            	String macp=rs.getString("MACP");
                String masan=rs.getString("MASAN");
                String tencty=rs.getString("TENCTY");
                String diachi=rs.getString("DIACHI");  
                String sdt=rs.getString("SDT");
                String fax=rs.getString("FAX");
                String diachiweb=rs.getString("DIACHIWEB");
                String email=rs.getString("EMAIL");  
                int slcp=rs.getInt("SLCP");
                COPHIEU s=new COPHIEU(macp, masan, tencty, diachi, sdt, fax, diachiweb, email, slcp);
                arr.add(s);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return arr;
    }
	public static void ThemCP(COPHIEU cp,NHANVIEN nv)
	{
		try
		{
			Connection connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String add = "INSERT INTO COPHIEU(MACP, MASAN, TENCTY, DIACHI, SDT, FAX, DIACHIWEB, EMAIL, SLCP) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, cp.getMacp());
			pst.setString(2, cp.getMasan());
			pst.setString(3, cp.getTencty());
			pst.setString(4, cp.getDiachi());
			pst.setString(5, cp.getSdt());
			pst.setString(6, cp.getFax());
			pst.setString(7, cp.getDiachiweb());
			pst.setString(8, cp.getEmail());
			pst.setInt(9, cp.getSlcp());
			pst.executeLargeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
