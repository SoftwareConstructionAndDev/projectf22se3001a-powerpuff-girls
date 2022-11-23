package DataBaseLayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DB 
{
	public Connection connection;
	public ArrayList<String> loadMeaning(String word)
	{
		ArrayList<String> list = new ArrayList<>();
		String jdbcUrl="jdbc:mysql://localhost:3306/dictionary";
		String username="root";
		String password="";
		String meaningReturn = "";
		try{
			connection = DriverManager.getConnection(jdbcUrl,username,password);
			connection.setAutoCommit(false);

			StringBuilder wordSearch = new StringBuilder();
			wordSearch.append(word);
			
			String readFaeel ="SELECT * FROM faeeltable WHERE mashkool = '" + wordSearch + "'";
			PreparedStatement statementFaeel=connection.prepareStatement(readFaeel);
			ResultSet rsFaeel = statementFaeel.executeQuery(readFaeel);
			
			String readMafoul = "SELECT * FROM mafoultable WHERE mashkool = '" + wordSearch + "'";
			PreparedStatement statementMafoul = connection.prepareStatement(readMafoul);
			ResultSet rsMafoul = statementMafoul.executeQuery(readMafoul);
			
			String readMasdar = "SELECT * FROM masdartable WHERE mashkool = '" + wordSearch + "'";
			PreparedStatement statementMasdar = connection.prepareStatement(readMasdar);
			ResultSet rsMasdar = statementMasdar.executeQuery(readMasdar);
			
			if(rsFaeel.next() && !rsMafoul.next() && !rsMasdar.next())
			{
				list.add(rsFaeel.getString(1));
				list.add(rsFaeel.getString(2));
				list.add(rsFaeel.getString(3));
				list.add(rsFaeel.getString(4));
				list.add(rsFaeel.getString(5));
				list.add(rsFaeel.getString(6));
				list.add(rsFaeel.getString(7));
				list.add(rsFaeel.getString(8));
				list.add(rsFaeel.getString(9));
			}
			
			else if(!rsFaeel.next() && rsMafoul.next() && !rsMasdar.next())
			{
				list.add(rsMafoul.getString(1));
				list.add(rsMafoul.getString(2));
				list.add(rsMafoul.getString(3));
				list.add(rsMafoul.getString(4));
				list.add(rsMafoul.getString(5));
				list.add(rsMafoul.getString(6));
				list.add(rsMafoul.getString(7));
				list.add(rsMafoul.getString(8));
				list.add(rsMafoul.getString(9));
			}
			
			else if(!rsFaeel.next() && !rsMafoul.next() && rsMasdar.next())
			{
				list.add(rsMasdar.getString(1));
				list.add(rsMasdar.getString(2));
				list.add(rsMasdar.getString(3));
				list.add(rsMasdar.getString(4));
				list.add(rsMasdar.getString(5));
				list.add(rsMasdar.getString(6));
				list.add(rsMasdar.getString(7));
				list.add(rsMasdar.getString(8));
				list.add(rsMasdar.getString(9));
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	

}