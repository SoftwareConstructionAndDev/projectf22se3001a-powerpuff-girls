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

public interface IFacadeDAL extends IDBHandler {
	public  ArrayList<String> getLoginData() throws SQLException;
	public String generateUnVocalizedForm(String word);
	public void insertData(LinkedList<String[]>list) throws SQLException;
	public LinkedList<String[]> getDicData() throws SQLException;
	public void createTables() throws SQLException;
	public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException;
	public ArrayList<String> getMeaningInArabic(String word) throws SQLException;
	public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException;
	public void updateInLughat(String mashkool, String sinf, String asal, String jins, String adad, String mani, String gm, String gs, String root) throws SQLException;
	public ArrayList<String> getRootsuggestions(String word) throws SQLException;
	public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException;
	public ArrayList<ArrayList <String>> getCustomDic(String text) throws SQLException;
	public java.sql.ResultSetMetaData getMetaDataOfDictionaryData() throws SQLException;
}
