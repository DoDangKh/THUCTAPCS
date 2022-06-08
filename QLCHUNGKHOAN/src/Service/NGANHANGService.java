package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.NGANHANG;
import Entity.NHANVIEN;
import QLCHUNGKHOAN.KetNoiDB;

public class NGANHANGService {
	public static ArrayList<NGANHANG> loadNH(NHANVIEN nv)
    {
        Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<NGANHANG> ar=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From NGANHANG");
            while(rs.next())
            {
            	String manh=rs.getString("MANH");
                String tennh=rs.getString("TENNH");
                NGANHANG s=new NGANHANG(manh, tennh);
                ar.add(s);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return ar;
    }
}
