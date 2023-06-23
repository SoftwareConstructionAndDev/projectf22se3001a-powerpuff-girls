package DataAccessLayer;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.oujda_nlp_team.AlKhalil2Analyzer;

public class DataBaseHandler implements IDBHandler{
	 
	 public DataBaseHandler() throws SQLException
	 {
		  
	 }
	/**
	 * @author Saliha Shahid
	 * @return
	 * @throws SQLException
	 */
	 
	 public void createTables() throws SQLException
	 {
		 Connection connection = DataBaseConnection.getConnection();
		//String query="create table لغت if not exists(رقم int(11) AUTO_INCREMENT PRIMARY KEY,مشکول text, صنف text, أصل text, جنس text, عدد text, معانی text, غیرمشکول text, غیرأصل text );";
			String createLughat="CREATE TABLE `لغت` IF NOT EXISTS( `رقم` int(11) NOT NULL AUTO_INCREMENT, `مشكول` text DEFAULT NULL, `صنف` text DEFAULT NULL, `أصل` varchar(1000) DEFAULT NULL, `جنس` text DEFAULT NULL, `عدد` text DEFAULT NULL, `معانی` text DEFAULT NULL, `غیرمشکول` text DEFAULT NULL, `غیرأصل` text DEFAULT NULL, `روٹ` text DEFAULT NULL, PRIMARY KEY (`رقم`), KEY `أصل` (`أصل`), CONSTRAINT `لغت_ibfk_1` FOREIGN KEY (`أصل`) REFERENCES `foreignkeytable` (`اصل`)) ENGINE=InnoDB AUTO_INCREMENT=15198 DEFAULT CHARSET=utf8";
	        String createRootTable="CREATE TABLE `roottable` (`رقم` int(11) NOT NULL AUTO_INCREMENT, `مشكول` text NOT NULL, `روٹ` text NOT NULL, PRIMARY KEY (`رقم`)) ENGINE=InnoDB AUTO_INCREMENT=1265 DEFAULT CHARSET=utf8\r\n";
	        String createRootfkTable="CREATE TABLE `rootfktable` IF NOT EXISTS(`ID` int(11) NOT NULL, `rootID` int(11) NOT NULL,  PRIMARY KEY (`ID`,`rootID`)) ENGINE=InnoDB DEFAULT CHARSET=utf8\r\n";
	        String createLoginTable="CREATE TABLE `login` IF NOT EXISTS(`Username` text NOT NULL, `Password` varchar(9) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	        String createfkTable="CREATE TABLE `foreignkeytable` IF NOT EXISTS(`اصل` varchar(1000) NOT NULL,  PRIMARY KEY (`اصل`), UNIQUE KEY `اصل` (`اصل`)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
	        PreparedStatement preparedStatementLughat=connection.prepareStatement(createLughat);
	        PreparedStatement preparedStatementRootTable=connection.prepareStatement(createRootTable);
	        PreparedStatement preparedStatementRootfkTable=connection.prepareStatement(createRootfkTable);
	        PreparedStatement preparedStatementLoginTable=connection.prepareStatement(createLoginTable);
	        PreparedStatement preparedStatementfkTable=connection.prepareStatement(createfkTable);
	        
	 }
	
	public  ArrayList<String> getLoginData() throws SQLException
	{
		//Connection con=connectDb();
		Connection connection = DataBaseConnection.getConnection();
		String query="Select * from login";
		Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<String> listOfLoginData=new ArrayList();
        while(resultSet.next())
        {
        	String stringForLoginData=resultSet.getString("Username");
        	listOfLoginData.add(stringForLoginData);
        	stringForLoginData=resultSet.getString("Password");
        	listOfLoginData.add(stringForLoginData);
        }
        connection.close();
        return listOfLoginData;
	}
	
	
	
	/**
	 * @author Saliha Shahid
	 * @param word
	 * @return list of possible root words
	 */
	public List<String> getRoots(String word)
	{
		AlKhalil2Analyzer analyzerToFindRoots = null;
		analyzerToFindRoots=analyzerToFindRoots.getInstance();
		return analyzerToFindRoots.processToken(word).getAllRoots();
	}
	
	
	public String generateUnVocalizedForm(String word)
	{
		String unvocalizedFormOfWord="";
		byte[] bytes=word.getBytes(StandardCharsets.UTF_8);
		String encodedWord=new String(bytes,StandardCharsets.UTF_8);
		//System.out.println(encodedWord);
		for(int i=0;i<encodedWord.length();i++)
		{
			if(encodedWord.charAt(i)!='َ'&&encodedWord.charAt(i)!='ِ'&&encodedWord.charAt(i)!='ٌ'&&encodedWord.charAt(i)!='ً'&&encodedWord.charAt(i)!='ٍ'&&encodedWord.charAt(i)!='ْ'&&encodedWord.charAt(i)!='ُ'&&encodedWord.charAt(i)!='ٗ')
			{
				unvocalizedFormOfWord=unvocalizedFormOfWord+encodedWord.charAt(i);
			}
		}
		return unvocalizedFormOfWord;
		}
	/**
	 * @author Saliha Shahid
	 * @param listOfWordsData
	 * @throws SQLException
	 */
	public void insertData(LinkedList<String[]>listOfWordsData) throws SQLException
	{
		//Connection con=connectDb();
		
		Connection con = DataBaseConnection.getConnection();
        for(int i=1;i<listOfWordsData.size();i++)
        {
        	String[] word=listOfWordsData.get(i);
        	String mashkool=word[1];
        	String sinf=word[2];
        	String asl=word[3];
        	String jins=word[4];
        	String adad=word[5];
        	String many="-";
        	String gm=generateUnVocalizedForm(word[1]);
        	String gs=generateUnVocalizedForm(word[3]);
        	insertInFKTable(asl);
        	insertInLughatTable(mashkool, sinf, asl, jins, adad, many, gm, gs);
        	Statement statement;
        	PreparedStatement preparedStatement;
        	List<String> listOfRoots=new ArrayList<String>();
          	listOfRoots=getRoots(mashkool);
          	for(int j=0;j<listOfRoots.size();j++)
          	{
          		String insertQueryForRootTable="INSERT INTO `roottable`(`روٹ`) VALUES ('"+listOfRoots.get(j)+"');";
              	preparedStatement = con.prepareStatement(insertQueryForRootTable);
              	String queryTogetRootID="SELECT 	`رقم` FROM `roottable` WHERE `روٹ`='"+listOfRoots.get(j)+"';";
          		statement =con.createStatement();
           	    ResultSet rootId = statement.executeQuery(queryTogetRootID);
           	    
          		String queryToGetMashkoolId="SELECT  `رقم` FROM `لغت` WHERE `مشكول`='"+mashkool+"';";
          		statement=con.createStatement();
          		ResultSet mashkoolId = statement.executeQuery(queryToGetMashkoolId);
          		
          		if(rootId.next()&&mashkoolId.next())
          		{
          			insertInRootFKTable(mashkoolId.getInt(1), rootId.getInt(1));	
          		}
          		
          		
          	}
          	
          	
          	
        }
        JOptionPane.showMessageDialog(null, " فائل امپورٹ ہو گئی ہے ");
        con.close();
        
          	
	}
	public void insertInFKTable(String asl) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String insertQuery="INSERT INTO `foreignkeytable`(`اصل`) VALUES ('"+asl+"');";
		String selectQueryForFKtable="Select * from foreignkeytable;";
    	Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(selectQueryForFKtable);
    	boolean found=false;
    	while(resultSet.next())
    	{
    		if (asl.equals(resultSet.getString(1))) {
    			 found=true;
        		 break;
    		 }
    		
    	 }
    	 if(!found)
    	 {
    		 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
           	 preparedStatement.executeUpdate(insertQuery); 
    	 }
    	 connection.close();
	}
	public void insertInLughatTable(String mashkool, String sinf, String asl, String jins, String adad, String many, String gm, String gs) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String insertIntoLughatQuery="INSERT INTO `لغت`( `مشكول`, `صنف`, `أصل`, `جنس`, `عدد`, `معانی`, `غیرمشکول`, `غیرأصل`) VALUES ('"+mashkool+"','"+sinf+"','"+asl+"','"+jins+"','"+adad+"','"+many+"','"+gm+"','"+gs+"')";
		 String selectQuery="SELECT * FROM `لغت`";
    	 boolean maskoolFound=false;
    	 PreparedStatement preparedStatement = connection.prepareStatement(insertIntoLughatQuery);
     	ResultSet resultSet=preparedStatement.executeQuery(selectQuery);
     	while(resultSet.next())
    	    {
    		 if (mashkool.equals(resultSet.getString(1))) {
    			maskoolFound=true;
        		 break;
    		 }
    		
    	   }
    	   if(!maskoolFound)
    	   {
    		 PreparedStatement preparedStatementForInsertQuery = connection.prepareStatement(insertIntoLughatQuery);
           	 preparedStatementForInsertQuery.executeUpdate(insertIntoLughatQuery); 
           	 }
    	   connection.close();
    	   }

	
	public void insertInRootFKTable(int id, int rootId) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String insertQueryForRootfkTable="INSERT INTO `rootfktable`(`ID`, `rootID`) VALUES ("+id+","+rootId+");";
		String selectQuery="Select * from rootfktable;";
    	Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(selectQuery);
    	boolean found=false;
    	while(resultSet.next())
    	{
    		if (id==resultSet.getInt(1)&&rootId==resultSet.getInt(2)) {
    			 found=true;
        		 break;
    		 }
    		
    	 }
    	 if(!found)
    	 {
    		PreparedStatement preparedStatement = connection.prepareStatement(insertQueryForRootfkTable);
    	  		preparedStatement.executeUpdate(insertQueryForRootfkTable);  
    	 }
  		connection.close();
    	   }

		
	public LinkedList<String[]> getDicData() throws SQLException
	{
		//Connection con=connectDb();
		Connection connection = DataBaseConnection.getConnection();
		String query="Select * from لغت";
		Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);	
        LinkedList<String[]> wordList=new LinkedList<String[]>();
        while(resultSet.next())
        {
        	String[] wordsData={"","","","","","","","","",""};
        	wordsData[0]=String.valueOf(resultSet.getInt(1));
        	wordsData[1]=resultSet.getString(2);
        	wordsData[2]=resultSet.getString(3);
        	wordsData[3]=resultSet.getString(4);
        	wordsData[4]=resultSet.getString(5);
        	wordsData[5]=resultSet.getString(6);
        	wordsData[6]=resultSet.getString(7);
        	wordsData[7]=resultSet.getString(8);
        	wordsData[8]=resultSet.getString(9);
        	wordsData[9]=resultSet.getString(10);
        	wordList.add(wordsData);
        	
        }
        connection.close();
        return wordList;
        
	}
	
	public java.sql.ResultSetMetaData getMetaDataOfDictionaryData() throws SQLException
	{
		//Connection con=connectDb();
		Connection con = DataBaseConnection.getConnection();
		String query="Select * from لغت";
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);	
        java.sql.ResultSetMetaData metaData=rs.getMetaData();
        return metaData;
        
	}
	
	public ArrayList<String> getMeaningInUrdu(String mashkool) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String selectQry="SELECT * FROM `لغت` WHERE مشكول LIKE '"+mashkool+"' OR غیرمشکول LIKE '"+mashkool+"';";
    	Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(selectQry);
    	ArrayList<String> wordData=new ArrayList<String>();
    	if(resultSet.next())
    	{
    		wordData.add(resultSet.getString(2));//mashkool
        	wordData.add(resultSet.getString(3));//sinf
        	wordData.add(resultSet.getString(4));//asal
        	wordData.add(resultSet.getString(5));//jins
        	wordData.add(resultSet.getString(6));//adad
        	wordData.add(resultSet.getString(7));//mani
        	wordData.add(resultSet.getString(8));//ghair mashkool
        	wordData.add(resultSet.getString(9));//ghair asal
        	wordData.add(resultSet.getString(10));//root
        	connection.close();
        	return wordData;
    	}
    	return null;
		
	}
	public ArrayList<String> getMeaningInArabic(String word) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String selectQry="SELECT * FROM `لغت` WHERE معانی LIKE '"+word+"';";
    	Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(selectQry);
    	ArrayList<String> wordData=new ArrayList<String>();
    	if(resultSet.next())
    	{
    		wordData.add(resultSet.getString(2));//mashkool
        	wordData.add(resultSet.getString(3));//sinf
        	wordData.add(resultSet.getString(4));//asal
        	wordData.add(resultSet.getString(5));//jins
        	wordData.add(resultSet.getString(6));//adad
        	wordData.add(resultSet.getString(7));//mani
        	wordData.add(resultSet.getString(8));//ghair mashkool
        	wordData.add(resultSet.getString(9));//ghair asal
        	wordData.add(resultSet.getString(10));//root
        	connection.close();
        	return wordData;
    	}
    	connection.close();
    	return null;
		
	}
	
	public ArrayList<String []> returnListOfMashkoolAgainstRoot(String root) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		///String queryToFetchDataFromRootTable="SELECT `مشكول` FROM `roottable` WHERE `روٹ` LIKE +'"+root+"';";
		//String selectQry="SELECT * FROM `لغت` WHERE `مشكول` IN ("+queryToFetchDataFromRootTable+";);";
		String queryToFetchDataFromRootTable="SELECT `مشكول` FROM `لغت` WHERE `رقم` IN\r\n"
				+ "( SELECT `ID` FROM `rootfktable` WHERE `rootid` IN\r\n"
				+ " (SELECT `رقم` FROM `roottable` WHERE `روٹ` LIKE '"+root+"'))";
		Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(queryToFetchDataFromRootTable);
    	ArrayList<String []> listOfWords=new ArrayList<String []>();
    	while(resultSet.next())
    	{
    		String[] wordList= {"","","","","","","",""};
    		wordList[0]=resultSet.getString(1);
    		/*wordList[1]=rs.getString(3);
    		wordList[2]=rs.getString(4);
    		wordList[3]=rs.getString(5);
    		wordList[4]=rs.getString(6);
    		wordList[5]=rs.getString(7);
    		wordList[6]=rs.getString(8);
    		wordList[7]=rs.getString(9);*/
    		listOfWords.add(wordList);
    		
    	}
    	connection.close();
    	return listOfWords;
    	
	}
	
	public void updateInLughat(String mashkool, String sinf, String asal, String jins, String adad, String mani, String gm, String gs, String root) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		//String query="UPDATE `لغت` SET `مشكول`='"+mashkool+"',`صنف`='"+sinf+"',`أصل`='"+asal+"',`جنس`='"+jins+"',`عدد`='"+adad+"',`معانی`='"+mani+"' WHERE  `مشكول` LIKE '"+mashkool+"';";
		String query="UPDATE `لغت` SET `مشكول`='"+mashkool+"',`صنف`='"+sinf+"',`أصل`='"+asal+"',`جنس`='"+jins+"',`عدد`='"+adad+"',`معانی`='"+mani+"',`غیرمشکول`='"+gm+"',`غیرأصل`='"+gs+"',`روٹ`='"+root+"' WHERE `مشكول` LIKE '"+mashkool+"';";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
       	 preparedStatement.executeUpdate(query);
		connection.close();
	}
	
	public ArrayList<String> getRootsuggestions(String word) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		//String query="SELECT `روٹ` FROM `roottable` WHERE `مشكول` LIKE '"+word+"';";
		String query="SELECT `روٹ` FROM `roottable` where `رقم` IN (SELECT `rootid` FROM `rootfktable` WHERE `id` IN   (SELECT `رقم` FROM `لغت` WHERE `مشكول` LIKE '"+word+"'))";
		Statement statement=connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(query);
    	ArrayList<String> roots=new ArrayList<String>();
    	
    		while(resultSet.next())
        	{
        		roots.add(resultSet.getString(1));
        	}
    		connection.close();
    		return roots;
    	
		
	}
	
	public void setRootInLughat(String mashkool, String selectedRoot) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		String query="UPDATE `لغت` SET `روٹ` = '"+selectedRoot+"' WHERE `مشكول` LIKE '"+mashkool+"';";
		 PreparedStatement preparedStatement = connection.prepareStatement(query);
       	 preparedStatement.executeUpdate(query);
       	JOptionPane.showMessageDialog(null, "روٹ اپڈیٹ ہو گیا ہے۔");
		connection.close();
	}
	
	
	public  ArrayList<String> splitString(String stringToBeSplitted)
	{
		System.out.println(stringToBeSplitted);
		ArrayList<String> listOfWordsInString=new ArrayList<String>();
		String word="";
		for(int i=0;i<stringToBeSplitted.length();i++)
		{
			if(stringToBeSplitted.charAt(i)==' ')
			{
				//System.out.println(word);
				listOfWordsInString.add(word);
				word="";
			}
			else if(i+1==stringToBeSplitted.length())
			{
				word=word+stringToBeSplitted.charAt(i);
				listOfWordsInString.add(word);
				word="";
			}
			else
			{
				word=word+stringToBeSplitted.charAt(i);
			}
		}
		return listOfWordsInString;
	}
	public ArrayList<ArrayList <String>> getCustomDic(String text) throws SQLException
	{
		Connection connection = DataBaseConnection.getConnection();
		//ArrayList<ArrayList <String>> customDicData=new ArrayList<ArrayList <String>>();
		ArrayList<String> wordsInText=splitString(text);
		ArrayList<ArrayList <String>> listOfSearchedWords=new ArrayList<ArrayList <String>>();
		for(int i=0;i<wordsInText.size();i++)
		{
			listOfSearchedWords.add(getMeaningInUrdu(wordsInText.get(i)));
		}
		
		connection.close();
		return listOfSearchedWords;
	}
	
	
	
}
