package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.PaymentDao;

public class PaymentDaoTest {

	@Test
	public void test() {
		PaymentDao paymentDao=new PaymentDao();
		System.out.println(paymentDao.getAllIncome());
	}

}
