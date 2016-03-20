package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Login;

public class LoginTest {

	@Test
	public void testLogin() {

		Login login = new Login();
		login.setLogin("loginTest1");
		
		assertEquals("loginTest1", login.getLogin());
	}
	
	@Test
	public void testPass() {

		Login login = new Login();
		login.setPass("loginPass1");
		
		assertEquals("loginPass1", login.getPassword());
	}

}
