package BusinessLogicLayer;

import java.sql.SQLException;

public interface IVerifyLogin {
	public boolean loginValidity(String un,String pass) throws SQLException;
}
