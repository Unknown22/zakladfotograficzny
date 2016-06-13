package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.HelpDao;
import dao.PriceListDao;
import model.Help;
import model.PriceList;

public class PriceListTest {

	@Test
	public void getPriceList() {

		System.out.println("PriceList test - getPriceList");
		PriceListDao dao = new PriceListDao();
		
		PriceList list = new PriceList();
		
		list = dao.getPriceList();
		System.out.println(list.toString());
		assertNotNull(list);
	}
	
	@Test 
	public void setPriceList(){
		System.out.println("PriceList test - savePriceList");
		PriceListDao dao = new PriceListDao();
		
		//PriceList list = new PriceList(55);
		PriceList list = new PriceList();
		list.setDefault();
		
		dao.savePriceList(list);
	}
}
