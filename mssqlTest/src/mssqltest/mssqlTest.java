package mssqltest;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
public class mssqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		String sDBUrl = "jdbc:sqlserver://192.168.0.123:1433;databaseName=test";
		String userName = "sa";
		String userPwd  = "6994596";
		
		Statement sql;
		ResultSet rs;
		
		Connection dbConn;
		
		try {
			Class.forName(sDriverName);
			dbConn = DriverManager.getConnection(sDBUrl, userName, userPwd); 
			sql=dbConn.createStatement();
			rs=sql.executeQuery("select * from table1");
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			dbConn.close();
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}

}
