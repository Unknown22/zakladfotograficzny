package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.DbUtil;

public class DbUtilTest {

	@Test
	public void test() {

		DbUtil db = new DbUtil();
		assertNotNull(db.getConnection());

	}

}
