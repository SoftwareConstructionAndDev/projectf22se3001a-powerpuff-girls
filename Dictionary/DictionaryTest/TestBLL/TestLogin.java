package TestBLL;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import BusinessLogicLayer.VerifyLogin;
public class TestLogin {
@Test
public void testLoginValidityForValidCredentials() throws SQLException
{
	VerifyLogin lg=new VerifyLogin();
	boolean found=lg.loginValidity("admin", "abc123");
	Assertions.assertTrue(found);
	}
@Test
public void testLoginValidityForInValidCredentials() throws SQLException
{
	VerifyLogin lg=new VerifyLogin();
	boolean found=lg.loginValidity("admin", "a23");
	Assertions.assertFalse(found);
	}

@Test
public void testLoginValidityForEmptyCredentials() throws SQLException
{
	VerifyLogin lg=new VerifyLogin();
	boolean found=lg.loginValidity(" ", " ");
	Assertions.assertFalse(found);
	}
}
