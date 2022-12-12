package BusinessLogicLayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException
	{
		return dbll.getMeaningInUrdu(mashkool);
	}
	
	public ArrayList<String> getMeaningInArabic(String word) throws SQLException
	{
		return dbll.getMeaningInArabic(word);
	}
	public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException
	{
		return dbll.returnListOfMashkoolAgainstRoot(root);
	}
	public void updateInLughat(String mashkool,String sinf, String asal,String jins, String adad,String mani) throws SQLException
	{
		dbll.updateInLughat(mashkool, sinf, asal, jins, adad, mani);
	}
	public ArrayList<String> getRootsuggestions(String word) throws SQLException
	{
		return dbll.getRootsuggestions(word);
	}
	public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException
	{
		dbll.setRootInLughat(mashkool, selectedRoot);
	}
}
