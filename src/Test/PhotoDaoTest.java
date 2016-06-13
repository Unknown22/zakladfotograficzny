package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import dao.PhotoDao;
import model.Photo;

public class PhotoDaoTest {

	@Test
	public void uploadPhoto() throws FileNotFoundException {
		File file = new File("photo1.png");
		InputStream is = new FileInputStream(file);
		Photo photo = new Photo(1, "test#1", 1, "png", 99, is);
		
		PhotoDao dao = new PhotoDao();
		
		try {
			assertTrue(dao.uploadPhoto(photo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error - uploading photo to DB");
		}		
	}
	
	@Test
	public void downloadPhoto(){
		PhotoDao dao = new PhotoDao();
		
		Photo tempPhoto = dao.getPhotoByIdPhoto(13);
		
		//System.out.println(tempPhoto);			
		
		if(tempPhoto.equals(null))
			assertTrue("See file temp.png ind main folder", true);
		
	}
	
}
