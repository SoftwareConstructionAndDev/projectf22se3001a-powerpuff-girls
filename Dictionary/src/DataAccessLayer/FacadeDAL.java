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
}
