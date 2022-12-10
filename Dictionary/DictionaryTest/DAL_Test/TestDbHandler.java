package DAL_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import DataAccessLayer.DataBaseHandler;
import DataAccessLayer.DataBaseConnection;
public class TestDbHandler {
	@Test
public void TestgenerateUnVocalizedFormForExpectedEqualActual() throws SQLException
{
		DataBaseHandler dbh=new DataBaseHandler();
		Assertions.assertEquals("متّخذ", dbh.generateUnVocalizedForm("مُتَّخِذٌ"));
		
	}
	
	@Test
	public void TestgenerateUnVocalizedFormForFalse() throws SQLException
	{
			DataBaseHandler dbh=new DataBaseHandler();
			Assertions.assertFalse(dbh.generateUnVocalizedForm("مُتَّخِذٌ") == "مُتَّخِذٌ");
			
		}
	//@Test
	/*public void testConnection() throws SQLException
	{
		//DataBaseHandler dbh=new DataBaseHandler();
		String url = "jdbc:mysql://localhost:3306/Dictionary?useSSL=false";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
		Assertions.assertTrue(DataBaseConnection.getConnection().equals(con));	
	}*/
	
	@Test
	public void testGetLoginDataForValidCredentials() throws SQLException
	{
		
		DataBaseHandler dbh=new DataBaseHandler();
		 Assertions.assertTrue(dbh.getLoginData().get(0).equals("admin") && dbh.getLoginData().get(1).equals("abc123"));
	}
	
	@Test
	public void testGetLoginDataForInValidCredentials() throws SQLException
	{
		DataBaseHandler dbh=new DataBaseHandler();
		 Assertions.assertFalse(dbh.getLoginData().get(0).equals("admin") && dbh.getLoginData().get(1).equals("123"));
	}
	
	@Test
	public void testGetLoginDataForEmptyCredentials() throws SQLException
	{
		DataBaseHandler dbh=new DataBaseHandler();
		 Assertions.assertFalse(dbh.getLoginData().get(0).equals(" ") || dbh.getLoginData().get(1).equals(" "));
	}
	
	@Test
	public void testGetRoots() throws SQLException
	{
		DataBaseHandler dbh=new DataBaseHandler();
		List<String> list=new ArrayList();
		list=dbh.getRoots("آتِي");
		List<String> elist=new ArrayList();
		elist.add("ءتي");
		elist.add("ءتو");
		 Assertions.assertEquals(elist,list);
	}
}
