package Test;

import static org.junit.Assert.*;
import controller.UserController;

import org.junit.Test;

public class EmailValidationTest {

	@Test
	public void test() {
		assertTrue(UserController.isValidEmailAddress("abc@mail.com"));
		assertFalse(UserController.isValidEmailAddress("asasd"));
	}

}
