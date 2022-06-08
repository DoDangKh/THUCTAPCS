package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.NHANVIEN;
import Entity.SANGIAODICH;
import QLCHUNGKHOAN.KetNoiDB;

public class SANGGIAODICHService {
	public static ArrayList<SANGIAODICH> loadSGD(NHANVIEN nv)
    {
        Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<SANGIAODICH> ar=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From SANGIAODICH");
            while(rs.next())
            {
            	String masan=rs.getString("MASAN");
                String tensan=rs.getString("TENSAN");
                SANGIAODICH s=new SANGIAODICH(masan, tensan);
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
