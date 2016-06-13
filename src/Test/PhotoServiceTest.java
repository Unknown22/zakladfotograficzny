package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.PhotoServiceDao;
import model.PhotoService;

public class PhotoServiceTest {

	@Test
	public void test() {
		PhotoService photoService=new PhotoService();
		PhotoServiceDao photoServiceDao=new PhotoServiceDao();
		photoService=photoServiceDao.getPhotoServiceById(1);
		System.out.println(photoService.toString());
		photoService=photoServiceDao.getPhotoServiceById(2);
		System.out.println(photoService.toString());
		
	}

}
