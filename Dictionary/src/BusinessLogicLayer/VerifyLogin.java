package BusinessLogicLayer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DataAccessLayer.DataBaseConnection;
import DataAccessLayer.DataBaseHandler;
import PresentationLayer.Login;
import DataAccessLayer.Facade;
public class VerifyLogin {
	/**
	 * @author Saliha Shahid
	 * @param un
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	private Facade facade=new Facade();
	private Connection con;
	public VerifyLogin() throws SQLException
	{
		con=DataBaseConnection.getConnection();
	}
	public boolean loginValidity(String un,String pass) throws SQLException
	{
		Login lg=new Login();
		//DataBaseHandler dbh=new DataBaseHandler();
		ArrayList<String> list=new ArrayList<String>();
		list=facade.getLoginData(con);
		System.out.println(un);
		System.out.println(pass);
		if((list.get(0)).equals(un)&&(list.get(1)).equals(pass))
		{
			
			return true;
		}
		return false;
	}

}
