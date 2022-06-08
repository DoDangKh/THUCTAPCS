package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import	Entity.*;
import QLCHUNGKHOAN.KetNoiDB;
public class NHADAUTUService {
	public static ArrayList<NHADAUTU> loadDS_NDT(NHANVIEN nv) throws SQLException{
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<NHADAUTU> arr=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * From NHADAUTU");
            while(rs.next())
            {
            	String MATK=rs.getString("MATK");
            	String HO=rs.getString("HO");
            	String TEN=rs.getString("TEN");
            	String NGAYSINH=rs.getString("NGAYSINH");
            	String NOISINH=rs.getString("NOISINH");
            	String PHAI=rs.getString("PHAI");
            	String DIACHI=rs.getString("DIACHI");
            	String EMAIL=rs.getString("EMAIL");
            	String SDT=rs.getString("SDT");
            	String CMND_PASSPORT=rs.getString("CMND_PASSPORT");
            	String NGAYCAP=rs.getString("NGAYCAP");
            	String NOICAP=rs.getString("NOICAP");
            	String NOILAMVIEC=rs.getString("NOILAMVIEC");
            	String MAGD=rs.getString("MAGD");
            	String MKDATLENH=rs.getString("MKDATLENH");
            	
            	NHADAUTU N = new NHADAUTU(MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT,
            			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH);
                arr.add(N);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }finally {
        	ketnoi.close();
        }
        return arr;
	}
	//themNDT
	public static int themNDT(NHADAUTU N,NHANVIEN nv) {
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String add = "INSERT INTO NHADAUTU (MATK, HO, TEN, NGAYSINH, NOISINH, PHAI, DIACHI, EMAIL, SDT, CMND_PASSPORT, "
					+ "            			NGAYCAP, NOICAP, NOILAMVIEC, MAGD, MKDATLENH) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, N.getMATK());
			pst.setString(2, N.getHO());
			pst.setString(3, N.getTEN());
			pst.setString(4, N.getNGAYSINH());
			pst.setString(5, N.getNOISINH());
			pst.setString(6, N.getPHAI());
			pst.setString(7, N.getDIACHI());
			pst.setString(8, N.getEMAIL());
			pst.setString(9, N.getSDT());
			pst.setString(10, N.getCMND_PASSPORT());
			pst.setString(11, N.getNGAYCAP());
			pst.setString(12, N.getNOICAP());
			pst.setString(13, N.getNOILAMVIEC());
			pst.setString(14, N.getMAGD());
			pst.setString(15, N.getMKDATLENH());
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
	//xoaNDT 
	public static int xoaNDT(String matk,NHANVIEN nv) {
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			
			//kiểm tra khoá ngoại
			
			String add = "DELETE FROM NHADAUTU WHERE MATK = ?";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, matk);
			
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
	//suaNDT
	public static int suaNDT(NHADAUTU N,NHANVIEN nv) {
		Connection connec = null;
		try
		{
			connec = KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String add = "UPDATE NHADAUTU SET MATK = ?, HO = ?, TEN = ?, NGAYSINH = ?, NOISINH = ?, PHAI = ?, DIACHI = ?, EMAIL = ?, SDT = ?, CMND_PASSPORT = ?, "
			+" NGAYCAP = ?, NOICAP = ?, NOILAMVIEC = ?, MAGD = ?, MKDATLENH = ? WHERE MATK = ?";
			PreparedStatement pst = connec.prepareStatement(add);
			pst.setString(1, N.getMATK());
			pst.setString(2, N.getHO());
			pst.setString(3, N.getTEN());
			pst.setString(4, N.getNGAYSINH());
			pst.setString(5, N.getNOISINH());
			pst.setString(6, N.getPHAI());
			pst.setString(7, N.getDIACHI());
			pst.setString(8, N.getEMAIL());
			pst.setString(9, N.getSDT());
			pst.setString(10, N.getCMND_PASSPORT());
			pst.setString(11, N.getNGAYCAP());
			pst.setString(12, N.getNOICAP());
			pst.setString(13, N.getNOILAMVIEC());
			pst.setString(14, N.getMAGD());
			pst.setString(15, N.getMKDATLENH());
			pst.setString(16, N.getMATK());
			
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
}	
