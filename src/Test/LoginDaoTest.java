package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.LoginDao;
import model.Login;

public class LoginDaoTest {
	
	

	@Test
	public void testTrue() {
		
		LoginDao dao = new LoginDao();
		Login login = new Login();
		
		login.setLogin("admin");
		login.setPass("admin");
		
		assertEquals(dao.authorization(login), 1);
		
	}
	
	@Test
	public void testFalse(){
		
		LoginDao dao = new LoginDao();
		Login login = new Login();
		
		login.setLogin("zaq1");
		login.setPass("qwerty");
		
		assertEquals(dao.authorization(login), 1);
		
	}

}
