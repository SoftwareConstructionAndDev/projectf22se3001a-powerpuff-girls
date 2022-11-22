package BusinessLogicLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import DataAccessLayer.DataBaseHandler;

public class DictionaryBLL {
	private  LinkedList<String[]>listOfWords=new LinkedList<String[]>();
	public DictionaryBLL(){}
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
	DataBaseHandler dbh=new DataBaseHandler();
	dbh.insertData(listOfWords);
	
	}

/**
 * @author Saliha Shahid
 * @return LinkedList<String[]>
 * @throws SQLException
 */
public static LinkedList<String[]> getDataFromDb() throws SQLException
{
	DataBaseHandler dbh=new DataBaseHandler();
	LinkedList<String[]> list=dbh.getDicData();
	return list;
	}

}
