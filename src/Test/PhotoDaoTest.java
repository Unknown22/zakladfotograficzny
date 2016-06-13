package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.PhotoDao;
import model.Photo;

public class PhotoDaoTest {

	@Test
	public void uploadPhoto() {
		File file = new File("photo1.png");
		Photo photo = new Photo(1, "test#1", 1, "png", 99, file);
		
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
		
		Photo tempPhoto = dao.getPhotoByIdPhoto(2);
		
		System.out.println(tempPhoto.toString());			
		
		if(tempPhoto.equals(null))
			assertTrue("See file temp.png ind main folder", true);
	}
	
	@Test
	public void getAllPhotos() throws IOException
	{
		List<Photo> photos = new ArrayList<Photo>();
		PhotoDao dao = new PhotoDao();
		photos=dao.getAllPhotos();
		
		for(Photo photo: photos)
		{
			System.out.println(photo.toString());
		}
	}
	
	
}
