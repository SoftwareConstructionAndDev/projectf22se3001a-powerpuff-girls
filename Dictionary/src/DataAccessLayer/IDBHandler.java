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

public interface IDBHandler {
	public  ArrayList<String> getLoginData() throws SQLException;
	public String generateUnVocalizedForm(String word);
	public void insertData(LinkedList<String[]>list) throws SQLException;
	public LinkedList<String[]> getDicData() throws SQLException;
	public void createTables() throws SQLException;
}
