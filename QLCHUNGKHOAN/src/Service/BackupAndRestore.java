package Service;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Entity.NHANVIEN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import QLCHUNGKHOAN.KetNoiDB;
import QLCHUNGKHOAN.formNhanVien;

public class BackupAndRestore {
	public boolean Backup(NHANVIEN nv) {
		Connection ketnoi=KetNoiDB.LayKetNoi(nv.getTaikhoan(),nv.getMatkhau());
		Statement statement=null;
		Statement st=null;
		try {
			statement=ketnoi.createStatement();
			st=ketnoi.createStatement();
			ResultSet rs=st.executeQuery("SELECT sdb.name [DB_NAME]\r\n"
										+ "FROM sys.sysdatabases sdb\r\n"
										+ "LEFT JOIN msdb.dbo.backupset bus ON bus.database_name = sdb.name\r\n"
										+ "WHERE bus.backup_finish_date IS NULL and sdb.name='QLGDCK2'");
			if(rs.next()) {
				System.out.print("chua co backup");
				String path=System.getProperty("user.dir");
				path+="\\Backup";
				String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				System.out.print(path);
				statement.execute("Backup database QLGDCK2 to disk = '"+path+"\\"+name+".bak'");
			}
			else {
				String path=System.getProperty("user.dir");
				path+="\\Backup";
				String name=new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				statement.execute("Backup database QLGDCK2 to disk = '"+path+"\\"+name+".bak' with differential");
				System.out.print("da co backup");
			}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean restore(String index,ArrayList<String> list) {
		Connection ketnoi=null;
		String url="jdbc:sqlserver://DESKTOP-RCUOH9C:1433";
		Statement st=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ketnoi=DriverManager.getConnection(url, "sa", "123456");
			System.out.print("ketnoithanhcong");
			st=ketnoi.createStatement();
			String path=System.getProperty("user.dir");
			path+="\\Backup";
			for(String s:list) {
				if(s.equals(index)) {
					break;
				}
				
				st.execute("restore database QLGDCK2 from disk= '"+path+"\\"+s+"' With NoRecovery");
			}
			st.execute("restore database QLGDCK2 from disk= '"+path+"\\"+index+"'");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
