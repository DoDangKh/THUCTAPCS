package QLCHUNGKHOAN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDB {
	public static Connection LayKetNoi(String UserName,String password)
	{
		Connection ketnoi=null;
		String url="jdbc:sqlserver://DESKTOP-RCUOH9C:1433;databaseName=QLGDCK2";
        //String UserName="sa";
        //String password="123456";
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ketnoi=DriverManager.getConnection(url, UserName, password);
			System.out.print("ketnoithanhcong");
		
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return ketnoi;
	}
}
