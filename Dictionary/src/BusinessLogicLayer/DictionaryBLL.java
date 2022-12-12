package BusinessLogicLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import DataAccessLayer.DataBaseConnection;
import DataAccessLayer.DataBaseHandler;
import DataAccessLayer.FacadeDAL;


public class DictionaryBLL implements IDictionaryBLL{
	private  LinkedList<String[]>listOfWords=new LinkedList<String[]>();
	private static Connection con;
	private  FacadeDAL facade=new FacadeDAL();
	public DictionaryBLL() throws SQLException{con=DataBaseConnection.getConnection();}
	/**
	 * @author Saliha Shahid
	 * @param file
	 * @throws IOException
	 * @throws SQLException
	 */
public void importFiles(File file) throws IOException, SQLException
{
	String line="";
	String splitBy=",";
	BufferedReader br=new BufferedReader(new FileReader(file));
	
	while((line=br.readLine())!=null)
	{
		
		String[] word=line.split(splitBy);
		listOfWords.add(word);
		
	}
	//DataBaseHandler dbh=new DataBaseHandler();
	facade.insertData(listOfWords);
	
	}

/**
 * @author Saliha Shahid
 * @return LinkedList<String[]>
 * @throws SQLException
 */
public LinkedList<String[]> getDataFromDb() throws SQLException
{
	//DataBaseHandler dbh=new DataBaseHandler();
	LinkedList<String[]> list=facade.getDicData();
	return list;
	}

public void createTables() throws SQLException
{
	facade.createTables();
	
	}
@Override
public void getConnection() throws SQLException {
	// TODO Auto-generated method stub
	
}
public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException
{
	return facade.getMeaningInUrdu(mashkool);
	}
public ArrayList<String> getMeaningInArabic(String word) throws SQLException
{
	return facade.getMeaningInArabic(word);
	}
public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException
{
	return facade.returnListOfMashkoolAgainstRoot(root);
	}
public void updateInLughat(String mashkool,String sinf, String asal,String jins, String adad,String mani) throws SQLException
{
	facade.updateInLughat(mashkool, sinf, asal, jins, adad, mani);
	}
public ArrayList<String> getRootsuggestions(String word) throws SQLException
{
	return facade.getRootsuggestions(word);
	}
public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException
{
	facade.setRootInLughat(mashkool, selectedRoot);
	}
}
