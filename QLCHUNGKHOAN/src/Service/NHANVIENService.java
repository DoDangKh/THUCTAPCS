package Service;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.NHANVIEN;
import QLCHUNGKHOAN.KetNoiDB;
public class NHANVIENService {
	public List<NHANVIEN> getList(NHANVIEN nv){
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        ArrayList<NHANVIEN> arr=new ArrayList<>();
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select * FROM NHANVIEN inner join TAIKHOAN on NHANVIEN.MANV=TAIKHOAN.MANV");
            while(rs.next())
            {
            	NHANVIEN s=new NHANVIEN();
            	s.setMANV(rs.getInt("MANV"));
            	s.setHO(rs.getString("HO"));
            	s.setTEN(rs.getString("TEN"));
            	s.setPHAI(rs.getString("PHAI"));
            	s.setDIACHI(rs.getString("DIACHI"));
            	s.setSDT(rs.getString("SDT"));
            	s.setLuong(rs.getInt("LUONG"));
            	s.setTaikhoan(rs.getString("TAIKHOAN"));
            	s.setMatkhau(rs.getString("MATKHAU"));
            	s.setNGAYSINH(rs.getString("NGAYSINH"));
                arr.add(s);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return arr;
	}
	//nữ
	public String getTK(int MANV,NHANVIEN nv) {
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        String temp=null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select TAIKHOAN FROM TAIKHOAN WHERE MANV="+MANV);
            while(rs.next())
            {	
            	System.out.print(1);
            	temp=rs.getString("TAIKHOAN");
            	temp.trim();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return temp;
	}
	public String getMK(int MANV,NHANVIEN nv) {
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
        Statement st=null;
        String temp=null;
        try
        {
            st=ketnoi.createStatement();
            ResultSet rs=st.executeQuery("Select MATKHAU FROM TAIKHOAN WHERE MANV="+MANV);
            while(rs.next())
            {
            	temp=rs.getString("MATKHAU");
            	temp.trim();
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return temp;
	}
	public NHANVIEN getlogin(String tk, String mk)
	{
		Connection ketnoi=KetNoiDB.LayKetNoi("sa","123456");
		Statement st=null;
		NHANVIEN temp=new NHANVIEN();
		try
        {
			st=ketnoi.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM NHANVIEN inner join TAIKHOAN on TAIKHOAN.MANV=NHANVIEN.MANV WHERE TAIKHOAN.TAIKHOAN='"+tk+ "' AND MATKHAU='"+mk+"'");
			while(rs.next())
            {
				temp.setMANV(rs.getInt("MANV"));
				temp.setHO(rs.getString("HO"));
				temp.setTEN(rs.getString("TEN"));
				temp.setPHAI(rs.getString("PHAI"));
				temp.setDIACHI(rs.getString("DIACHI"));
				temp.setSDT(rs.getString("SDT"));
				temp.setLuong(rs.getInt("LUONG"));
				temp.setTaikhoan(rs.getString("TAIKHOAN"));
				temp.setMatkhau(rs.getString("MATKHAU")); 
				temp.setRole(rs.getString("ROLE"));
				temp.setNGAYSINH(rs.getString("NGAYSINH"));
				return temp;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
		return null;
	}
	public boolean Insert(NHANVIEN s,NHANVIEN nv) {
		try {
			System.out.print(nv.getTaikhoan());
			Connection connec=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			String q1="Insert into NHANVIEN(MANV,HO,TEN,PHAI,DIACHI, SDT,LUONG,NGAYSINH) values(?,?,?,?,?,?,?,?)";
			String q2="Insert into TAIKHOAN(TAIKHOAN,MATKHAU,MANV,ROLE) values(?,?,?,?)";
			PreparedStatement pst=connec.prepareStatement(q1);
			pst.setInt(1 ,s.getMANV());
			byte[] temp1=s.getHO().getBytes();
			String temp=new String(temp1,StandardCharsets.UTF_8);
			pst.setString(2 ,temp);
			 temp1=s.getTEN().getBytes();
			 temp=new String(temp1,StandardCharsets.UTF_8);
			pst.setString(3,temp);
			temp1=s.getPHAI().getBytes();
			 temp=new String(temp1,StandardCharsets.UTF_8);
			pst.setString(4,temp);
			pst.setString(5, s.getDIACHI());
			pst.setString(6,s.getSDT());
			pst.setInt(7, s.getLuong());
			pst.setString(8, s.getNGAYSINH());
			pst.executeUpdate();
			pst=connec.prepareStatement(q2);
			pst.setString(1, s.getTaikhoan());
			pst.setString(2, s.getMatkhau());
			pst.setInt(3, s.getMANV());
			pst.setString(4, "NV");
			pst.executeUpdate();
			pst.setString(4,"NV");
			Statement st=null;
			st=connec.createStatement();
			st.executeUpdate("Create Login "+s.getTaikhoan()+" with password='"+s.getMatkhau()+"'");
			st.executeUpdate("Create user "+s.getTaikhoan()+" for login "+s.getTaikhoan());
			st.executeUpdate("Exec Sp_addRoleMember 'NHANVIEN' , '"+s.getTaikhoan()+"'");
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int s,String taikhoan,NHANVIEN nv) {
		try {
			Connection connec=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			Statement st=connec.createStatement();
			String query="Delete From NHANVIEN Where MANV="+s;
			String q1="DROP LOGIN "+taikhoan;
			String q2="Delete FROM TAIKHOAN Where MANV="+s;
			String q3="Drop USER "+taikhoan;
			st.execute(q2);
			st.execute(query);
			st.execute(q1);
			st.execute(q3);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(NHANVIEN s,NHANVIEN nv) {
		try {
			Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
			byte[] temp1=s.getHO().getBytes();
			System.out.print(s.getHO()+s.getPHAI());
			String tempHO=new String(temp1,StandardCharsets.UTF_8);
			temp1=s.getTEN().getBytes();
			String tempTEN=new String(temp1,StandardCharsets.UTF_8);
			temp1=s.getPHAI().getBytes();
			String tempPHAI=new String(temp1,StandardCharsets.UTF_8);
			String q1="update NHANVIEN Set HO=? , TEN=? ,PHAI=? ,DIACHI=? , SDT=? ,LUONG=? WHERE MANV="+s.getMANV();
			PreparedStatement pst=ketnoi.prepareStatement(q1);
			pst.setString(1, tempHO);
			pst.setString(2, tempTEN);
			pst.setString(3, tempPHAI);
			pst.setString(4, s.getDIACHI());
			pst.setString(5, s.getSDT());
			pst.setInt(6, s.getLuong());
			pst.executeUpdate();
			Statement st=ketnoi.createStatement();
			ResultSet rs=st.executeQuery("Select TAIKHOAN FROM TAIKHOAN WHERE MANV='"+s.getMANV()+"'");
			String temp=null;
			while(rs.next()) {
				temp=rs.getString("TAIKHOAN");
			}
			//Nữ
			//Statement st=ketnoi.createStatement();
			pst.executeUpdate();
			st.executeUpdate("ALTER LOGIN "+temp+" WITH PASSWORD='"+s.getMatkhau()+"'");
			st.executeUpdate("ALTER LOGIN "+temp+" WITH NAME="+s.getTaikhoan());
			String q2="UPDATE TAIKHOAN SET TAIKHOAN=?,  MATKHAU=? WHERE MANV="+s.getMANV();
			pst=ketnoi.prepareStatement(q2);
			pst.setString(1, s.getTaikhoan());
			pst.setString(2, s.getMatkhau());
			pst.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
