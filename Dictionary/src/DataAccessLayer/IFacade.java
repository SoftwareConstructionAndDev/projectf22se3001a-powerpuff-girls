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

public interface IFacade extends IDBHandler {
	public  ArrayList<String> getLoginData(Connection con) throws SQLException;
	public String generateUnVocalizedForm(String word);
	public void insertData(LinkedList<String[]>list, Connection con) throws SQLException;
	public LinkedList<String[]> getDicData(Connection con) throws SQLException;
}
