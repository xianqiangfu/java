package meilingjianche;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
public class MSSQLOperation {
	private Connection dbConn_ = null;
	private String IP = "192.168.0.123";
	private String PORT = "1433";
	private String DATABASE = "test";
	private String sDBUrl = "jdbc:sqlserver://" + this.IP + ":" + this.PORT + ";databaseName=" + this.DATABASE;
	
	public MSSQLOperation(String ip, String port, String database) {
		this.IP = ip;
		this.PORT = port;
		this.DATABASE = database;
	}
	
	public void GetConnection()  {
		if (null != dbConn_ ) return; //|| !dbConn_.isClosed()
		try {
			if (!dbConn_.isClosed()) return;
			System.out.println(sDBUrl);
			Class.forName(Config.DRIVERNAME);
			System.out.println(sDBUrl);
			dbConn_ = DriverManager.getConnection(sDBUrl, Config.USER, Config.PASSWORD);
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}
	
	public void CloseConnection() {
		try {
			dbConn_.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet GetResultSet(String sSQL) {
		if (null == dbConn_) return null;
		ResultSet rs = null;
		try {
			Statement sm = dbConn_.createStatement();
			System.out.println(sSQL);
			rs = sm.executeQuery(sSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}