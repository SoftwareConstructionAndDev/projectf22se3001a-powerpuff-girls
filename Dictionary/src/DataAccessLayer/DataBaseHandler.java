package DataAccessLayer;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class DataBaseHandler {
	/**
	 * @author Saliha Shahid
	 * @return
	 * @throws SQLException
	 */
	public  Connection connectDb() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        //System.out.println("Connected");
        return con;
	}
	
	/**
	 * @author Saliha Shahid
	 * @return
	 * @throws SQLException
	 */
	public  ArrayList<String> getLoginData() throws SQLException
	{
		Connection con=connectDb();
		String query="Select * from login";
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<String> list=new ArrayList();
        while(rs.next())
        {
        	String str=rs.getString("Username");
        	list.add(str);
        	str=rs.getString("Password");
        	list.add(str);
        }
        return list;
	}
	
	/**
	 * @author Saliha Shahid
	 * @param word
	 * @return
	 */
	public String generateUnVocalizedForm(String word)
	{
		String temp="";
		byte[] bytes=word.getBytes(StandardCharsets.UTF_8);
		String encodedWord=new String(bytes,StandardCharsets.UTF_8);
		//System.out.println(encodedWord);
		for(int i=0;i<encodedWord.length();i++)
		{
			if(encodedWord.charAt(i)!='َ'&&encodedWord.charAt(i)!='ِ'&&encodedWord.charAt(i)!='ٌ'&&encodedWord.charAt(i)!='ً'&&encodedWord.charAt(i)!='ٍ'&&encodedWord.charAt(i)!='ْ'&&encodedWord.charAt(i)!='ُ'&&encodedWord.charAt(i)!='ٗ')
			{
				temp=temp+encodedWord.charAt(i);
			}
		}
		return temp;
		}
	/**
	 * @author Saliha Shahid
	 * @param list
	 * @throws SQLException
	 */
	public void insertData(LinkedList<String[]>list) throws SQLException
	{
		Connection con=connectDb();
		
        for(int i=1;i<list.size();i++)
        {
        	String[] word=list.get(i);
        	String mashkool=word[1];
        	String sinf=word[2];
        	String asl=word[3];
        	String jins=word[4];
        	String adad=word[5];
        	String many="-";
        	String gm=generateUnVocalizedForm(word[1]);
        	String gs=generateUnVocalizedForm(word[3]);
        	String query="INSERT INTO `لغت`( `مشكول`, `صنف`, `أصل`, `جنس`, `عدد`, `معانی`, `غیرمشکول`, `غیرأصل`) VALUES ('"+mashkool+"','"+sinf+"','"+asl+"','"+jins+"','"+adad+"','"+many+"','"+gm+"','"+gs+"')";
        	String query2="INSERT INTO `foreignkeytable`(`اصل`) VALUES ('"+asl+"');";
        	String selQry="Select * from foreignkeytable;";
        	Statement st1=con.createStatement();
        	 ResultSet rs = st1.executeQuery(selQry);
        	 boolean found=false;
        	 while(rs.next())
        	 {
        		 if (asl.equals(rs.getString(1))) {
        			 found=true;
            		 break;
        		 }
        		
        	 }
        	 if(!found)
        	 {
        		 PreparedStatement st2 = con.prepareStatement(query);
               	 st2.executeUpdate(query2); 
        	 }
        	
        	PreparedStatement st = con.prepareStatement(query);
        	 st.executeUpdate(query);
        	 
        	 
        	
        }
		
	}
	public LinkedList<String[]> getDicData() throws SQLException
	{
		Connection con=connectDb();
		String query="Select * from لغت";
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);	
        LinkedList<String[]> list=new LinkedList<String[]>();
        while(rs.next())
        {
        	String[] wordsData={"","","","","","","","",""};
        	wordsData[0]=String.valueOf(rs.getInt(1));
        	wordsData[1]=rs.getString(2);
        	wordsData[2]=rs.getString(3);
        	wordsData[3]=rs.getString(4);
        	wordsData[4]=rs.getString(5);
        	wordsData[5]=rs.getString(6);
        	wordsData[6]=rs.getString(7);
        	wordsData[7]=rs.getString(8);
        	wordsData[8]=rs.getString(9);
        	list.add(wordsData);
        	
        }
        return list;
	}
}
