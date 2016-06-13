package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.SealingDao;

public class SealingDaoTest {

	@Test
	public void test() {
		SealingDao sd=new SealingDao();
		System.out.println(sd.getSealingPrice(1));
		System.out.println(sd.getSealingPrice(2));
	}

}
