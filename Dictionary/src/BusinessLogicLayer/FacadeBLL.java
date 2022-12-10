package BusinessLogicLayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class FacadeBLL implements IFacadeBLL {
	private IDictionaryBLL dbll;
	private IVerifyLogin vl;
	public FacadeBLL() throws SQLException
	{
		dbll=new DictionaryBLL();
		vl=new VerifyLogin();
	}
	public void createTables() throws SQLException
	{
		dbll.createTables();	
	}
	public boolean loginValidity(String un,String pass) throws SQLException
	{
		return vl.loginValidity(un, pass);
	}
	public void importFiles(File file) throws IOException, SQLException
	{
		dbll.importFiles(file);
	}
	public LinkedList<String[]> getDataFromDb() throws SQLException
	{
		return dbll.getDataFromDb();
	}
	@Override
	public void getConnection() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
