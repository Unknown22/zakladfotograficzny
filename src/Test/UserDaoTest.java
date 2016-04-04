package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.User;
import dao.UserDao;

public class UserDaoTest {

	@Test
	public void createUserInDB() {
		
		UserDao userDao=new UserDao();
		User user=new User("Jan", "Sztygar", "jansztygar@gmail.com", "user1", "user1", 1, 0);
		
		assertTrue(userDao.createUser(user));
	}
	
	@Test
	public void getAllUsers(){
		
		UserDao userDao=new UserDao();
		if(userDao.getAllUsers() != null){
			assertTrue(true);
		}
//		
//		System.out.println("Test, getAllUsers");
//		System.out.println(userDao.getAllUsers());
		
	}

	
	
}
