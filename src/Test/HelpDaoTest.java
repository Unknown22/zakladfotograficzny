package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.HelpDao;
import model.Help;

public class HelpDaoTest {

	@Test
	public void sendHelpToDB() {

		HelpDao helpDao = new HelpDao();

		Help help = new Help("junit@test.com", "Test Message From JUnit");

		assertTrue(helpDao.sendHelp(help));
	}
}
