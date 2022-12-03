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
public class Facade implements IFacade {
private IDBHandler dbHandler=new DataBaseHandler();
public  ArrayList<String> getLoginData(Connection con) throws SQLException
{
	return dbHandler.getLoginData(con);
	}
public String generateUnVocalizedForm(String word)
{
	return dbHandler.generateUnVocalizedForm(word);
	}
public void insertData(LinkedList<String[]>list, Connection con) throws SQLException
{
	dbHandler.insertData(list, con);
	}
public LinkedList<String[]> getDicData(Connection con) throws SQLException
{
	return dbHandler.getDicData(con);
	}
}
