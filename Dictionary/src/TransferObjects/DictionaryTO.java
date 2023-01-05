package TransferObjects;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import DataAccessLayer.DataBaseHandler;

public class DictionaryTO {
private LinkedList<String[]> dictionaryData;
private ArrayList<String[]> mashkoolList;
private ArrayList<String> rootSuggestions;
private DataBaseHandler databaseHandler;
private ArrayList<String> wordDataAgainstSearchForUrdu;
private ArrayList<String> wordDataAgainstSearchForArabic;
public DictionaryTO() throws SQLException
{
	dictionaryData=new LinkedList<String []>();
	mashkoolList = new ArrayList<String []>();
	rootSuggestions=new ArrayList<String>();
	wordDataAgainstSearchForUrdu=new ArrayList<String>();
	wordDataAgainstSearchForArabic=new ArrayList<String>();
	databaseHandler=new DataBaseHandler();
}
public LinkedList<String []> getDataFromDictionary() throws SQLException
{
	dictionaryData=databaseHandler.getDicData();
	return dictionaryData;
}

public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException
{
	wordDataAgainstSearchForUrdu=databaseHandler.getMeaningInUrdu(mashkool);
	return wordDataAgainstSearchForUrdu;
	}
public ArrayList<String> getMeaningInArabic(String word) throws SQLException
{
	wordDataAgainstSearchForArabic=databaseHandler.getMeaningInArabic(word);
	return wordDataAgainstSearchForArabic;
	}

public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException
{
	mashkoolList=databaseHandler.returnListOfMashkoolAgainstRoot(root);
	return mashkoolList;
}
public ArrayList<String> getRootsuggestions(String word) throws SQLException
{
	rootSuggestions=databaseHandler.getRootsuggestions(word);
	return rootSuggestions;
	}
}
