package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Order;

import dao.OrderDao;

public class OrderDaoTest {

	@Test
	public void createOrderInDB(){
		
		OrderDao dao = new OrderDao();
		
		Order order = new Order(1, "Tescik3...", 1, 1, 0);
		
		assertTrue(dao.createOrder(order));
		
	}
	
}
