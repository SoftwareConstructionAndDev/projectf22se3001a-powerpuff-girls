package BusinessLogicLayer;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public interface IDictionaryBLL {
	public void importFiles(File file) throws IOException, SQLException;
	public LinkedList<String[]> getDataFromDb() throws SQLException;
	public void getConnection() throws SQLException;
}
