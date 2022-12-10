package BusinessLogicLayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IFacadeBLL extends IVerifyLogin, IDictionaryBLL{
	public boolean loginValidity(String un,String pass) throws SQLException;
	public void importFiles(File file) throws IOException, SQLException;
	public LinkedList<String[]> getDataFromDb() throws SQLException;
	public void getConnection() throws SQLException;
	public void createTables() throws SQLException;
}
