package BusinessLogicLayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

public interface IFacadeBLL extends IVerifyLogin, IDictionaryBLL{
	public boolean loginValidity(String un,String pass) throws SQLException;
	public void importFiles(File file) throws IOException, SQLException;
	public LinkedList<String[]> getDataFromDb() throws SQLException;
	public void getConnection() throws SQLException;
	public void createTables() throws SQLException;
	public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException;
	public ArrayList<String> getMeaningInArabic(String word) throws SQLException;
	public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException;
	public void updateInLughat(String mashkool,String sinf, String asal,String jins, String adad,String mani) throws SQLException;
	public ArrayList<String> getRootsuggestions(String word) throws SQLException;
	public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException;
	public ArrayList<ArrayList <String>> getCustomDic(String text) throws SQLException;
	public void insertInLughatTable(String mashkool, String sinf, String asl, String jins, String adad, String many, String gm, String gs) throws SQLException;
	public String generateUnVocalizedForm(String word);
}
