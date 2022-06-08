package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Entity.*;
import QLCHUNGKHOAN.KetNoiDB;
public class LENHDATService {
	public static ArrayList<LENHDAT> loadDS_LD(NHANVIEN nv) throws SQLException{
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<LENHDAT> arr=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From LENHDAT");
            while(rs.next())
            {
            	String MALENH=rs.getString("MALENH");
            	String MACP=rs.getString("MACP");
            	String MATKNH=rs.getString("MATKNH");
            	String LOAIGD=rs.getString("LOAIGD");
            	String SLDAT=rs.getString("SLDAT");
            	String GIADAT=rs.getString("GIADAT");
            	String NGAYGIODAT=rs.getString("NGAYGIODAT");
            	String MATT=rs.getString("MATT");
            	String MALOAILENH=rs.getString("MALOAILENH");
            	
            	LENHDAT L = new LENHDAT(MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH);
                arr.add(L);
            }
            if(arr.size()>0) System.out.println("True");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	ketnoi.close();
        }
        return arr;
	}
	//themLD
	public static int themLD(LENHDAT L,NHANVIEN nv){
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String add = "INSERT INTO LENHDAT(MALENH, MACP, MATKNH, LOAIGD, SLDAT, GIADAT, NGAYGIODAT, MATT, MALOAILENH) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, L.getMALENH());
			pst.setString(2, L.getMACP());
			pst.setString(3, L.getMATKNH());
			pst.setString(4, L.getLOAIGD());
			pst.setString(5, L.getSLDAT());
			pst.setString(6, L.getGIADAT());
			pst.setString(7, L.getNGAYGIODAT());
			pst.setString(8, L.getMATT());
			pst.setString(9, L.getMALOAILENH());
			
			pst.executeLargeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			try {
				connec.close();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//xoaLD
	public static int xoaLD(String mald,NHANVIEN nv) {
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			
			String add = "DELETE FROM LENHDAT WHERE MALENH = ?";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, mald);
			pst.executeLargeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			try {
				connec.close();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//suaLD
	public static int suaLD(LENHDAT L,NHANVIEN nv) {
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String add = "UPDATE LENHDAT SET MALENH=?, MACP=?, MATKNH=?, LOAIGD=?, SLDAT=?, GIADAT=?, NGAYGIODAT=?, MATT=?, MALOAILENH=? WHERE MALENH=?";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, L.getMALENH());
			pst.setString(2, L.getMACP());
			pst.setString(3, L.getMATKNH());
			pst.setString(4, L.getLOAIGD());
			pst.setInt(5, Integer.valueOf(L.getSLDAT()));
			pst.setObject(6, L.getGIADAT());
			pst.setObject(7, L.getNGAYGIODAT());
			pst.setString(8, L.getMATT());
			pst.setString(9, L.getMALOAILENH());
			pst.setString(10, L.getMALENH());
			pst.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			try {
				connec.close();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	//loadDS_TrangThai
	public static KeyValue[] loadDS_TrangThai(NHANVIEN nv){
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<KeyValue> arr=new ArrayList<>();
        KeyValue[] items = null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select MATT, TENTT From TRANGTHAI");
            while(rs.next())
            {
            	String MATT = rs.getString("MATT");
            	String TENTT = rs.getString("TENTT");
            	
            	KeyValue k = new KeyValue(TENTT, MATT);
                arr.add(k);
            }
            
            items = new KeyValue[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
				items[i] = arr.get(i);
			}
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	try {
				ketnoi.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return items;
	}
	//loadDS_CoPhieu
	public static KeyValue[] loadDS_CoPhieu(NHANVIEN nv){
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<KeyValue> arr=new ArrayList<>();
        KeyValue[] items = null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select MACP, TENCP=MACP+'-'+TENCTY From COPHIEU");
            while(rs.next())
            {
            	String MACP = rs.getString("MACP");
            	String TENCP = rs.getString("TENCP");
            	
            	KeyValue k = new KeyValue(TENCP, MACP);
                arr.add(k);
            }
            
            items = new KeyValue[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
				items[i] = arr.get(i);
			}
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	try {
				ketnoi.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return items;
	}
	//loadDS_TKNH
	public static String[] loadDS_TKNH(NHANVIEN nv){
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<String> arr=new ArrayList<>();
        String[] items = null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select MATKNH From TKNH");
            while(rs.next())
            {
            	String MATKNH = rs.getString("MATKNH");
                arr.add(MATKNH);
            }
            
            items = new String[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
				items[i] = arr.get(i);
			}
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	try {
				ketnoi.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return items;
	}
	//loadDS_MaLoaiLenh
	public static KeyValue[] loadDS_MaLoaiLenh(NHANVIEN nv){
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<KeyValue> arr=new ArrayList<>();
        KeyValue[] items = null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select MALOAILENH, TENLENH From LOAILENH");
            while(rs.next())
            {
            	String MALOAILENH = rs.getString("MALOAILENH");
            	String TENLENH = rs.getString("TENLENH");
            	
            	KeyValue k = new KeyValue(TENLENH, MALOAILENH);
                arr.add(k);
            }
            
            items = new KeyValue[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
				items[i] = arr.get(i);
			}
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	try {
				ketnoi.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return items;
	}
	public static Date getDate(String day, String month, String year) {

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-" + day);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return date;
	}
}
