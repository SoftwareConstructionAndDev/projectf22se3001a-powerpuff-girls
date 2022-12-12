package DataAccessLayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author Saliha Shahid
 *
 */
public class FacadeDAL implements IFacadeDAL {
private IDBHandler dbHandler;
public FacadeDAL() throws SQLException
{
	dbHandler=new DataBaseHandler();
	}
public  ArrayList<String> getLoginData() throws SQLException
{
	return dbHandler.getLoginData();
	}
public String generateUnVocalizedForm(String word)
{
	return dbHandler.generateUnVocalizedForm(word);
	}
public void insertData(LinkedList<String[]>list) throws SQLException
{
	dbHandler.insertData(list);
	}
public LinkedList<String[]> getDicData() throws SQLException
{
	return dbHandler.getDicData();
	}
public void createTables() throws SQLException
{
	dbHandler.createTables();
	}
public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException
{
	return dbHandler.getMeaningInUrdu(mashkool);
	}
public ArrayList<String> getMeaningInArabic(String word) throws SQLException
{
	return dbHandler.getMeaningInArabic(word);
	}
public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException
{
	return dbHandler.returnListOfMashkoolAgainstRoot(root);
	}
public void updateInLughat(String mashkool,String sinf, String asal,String jins, String adad,String mani) throws SQLException
{
	dbHandler.updateInLughat(mashkool, sinf, asal, jins, adad, mani);
	}
public ArrayList<String> getRootsuggestions(String word) throws SQLException
{
	return dbHandler.getRootsuggestions(word);
	}
public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException
{
	 dbHandler.setRootInLughat(mashkool, selectedRoot);
	}
}
