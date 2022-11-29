package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	 private static DataBaseConnection dbc;
	 private static  Connection con;
	private DataBaseConnection() throws SQLException
	{
		
	}
	/**
	 * @author Saliha Shahid
	 * @return db connection
	 * @throws SQLException 
	 */
	
	public static Connection getConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false";
        String user = "root";
        String password = "";
        con = DriverManager.getConnection(url, user, password);
		return con;
	}

}
