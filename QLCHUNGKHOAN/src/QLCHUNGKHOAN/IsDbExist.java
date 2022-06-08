package QLCHUNGKHOAN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
 
public class IsDbExist {
 
	public static boolean check(){
 
		Connection con = null;
		ResultSet rs = null;
 
		String url = "jdbc:sqlserver://localhost:1433";
		String user = "sa";
		String password = "123456";
 
		try{
 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
		con = DriverManager.getConnection(url, user, password);
		
		String dbName = "QLGDCK2";
 
		if(con != null){
		
		System.out.println("check if a database exists using java");
 
		rs = con.getMetaData().getCatalogs();
 
		while(rs.next()){
		String catalogs = rs.getString(1);
		
		if(dbName.equals(catalogs)){
		System.out.println("the database "+dbName+" exists");
		return true;
		}
		}
 
		}
		else{
		System.out.println("unable to create database connection");
		return false;
		}
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
		finally{
		if( rs != null){
		try{
	    rs.close();
		}
		catch(SQLException ex){
		ex.printStackTrace();
		}
		}
		if( con != null){
		try{
	    con.close();
		}
		catch(SQLException ex){
		ex.printStackTrace();
		}
		}
		}
		return false;
	}
}