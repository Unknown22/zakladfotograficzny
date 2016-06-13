package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.xml.sax.InputSource;
import model.Order;
import model.Photo;
import util.DbUtil;

public class PhotoDao {

	private Connection connection;

	public PhotoDao() {
		this.connection = DbUtil.getConnection();
	}

	public boolean uploadPhoto(Photo photo) throws FileNotFoundException {

		System.out.println("PhotoDao: upload photo to db...");

		try {
			PreparedStatement ps = connection.prepareStatement("" + "INSERT INTO `photo` "
					+ "(`id_photo`, `id_order`, `file_name`, `id_service`, `file_type`, `file_size`, `binary_file`) "
					+ "VALUES " + "(NULL, ?, ?,	?, ?, ?, ?);");

			ps.setInt(1, photo.getIdOrder());
			ps.setString(2, photo.getFileName());
			ps.setInt(3, photo.getIdService());
			ps.setString(4, photo.getFileType());
			ps.setLong(5, photo.getFileSize());

			FileInputStream input = new FileInputStream(photo.getBinaryFile());
			ps.setBinaryStream(6, input);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Upload photo sql error");
			e.printStackTrace();
			return false;
		}

		System.out.println("Upload photo succesful");
		return true;
	}

	public Photo getPhotoByIdPhoto(int id) {
		System.out.println("PhotoDao: download photo from db...");

		Photo tempPhoto = null;

		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM `photo` WHERE `photo`.`id_photo`="+ id );

			while (rs.next()) {

				tempPhoto = new Photo();

				tempPhoto.setIdPhoto(rs.getInt("id_photo"));
				tempPhoto.setIdOrder(rs.getInt("id_order"));
				tempPhoto.setFileName(rs.getString("file_name"));
				tempPhoto.setIdService(rs.getInt("id_service"));
				tempPhoto.setFileType(rs.getString("file_type"));
				
				File image = new File("temp.png");				
				FileOutputStream fos = new FileOutputStream(image);

			      byte[] buffer = new byte[1];
			      InputStream is = rs.getBinaryStream("binary_file");
			      while (is.read(buffer) > 0) {
			        fos.write(buffer);
			      }
			      
			      fos.close();
				tempPhoto.setBinaryFile(image);
				tempPhoto.setFileSize(image.length());
				
			}

		} catch (SQLException | IOException e) {
			System.out.println("Error - download photo");
			e.printStackTrace();
			return tempPhoto;
		}

		System.out.println("PhotoDao: download photo from db complete...");
		return tempPhoto;

	}
	
	
	public List<Photo> getAllPhotos(){
		
		List<Photo> photos = new ArrayList<Photo>();
		
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `photo`");
            
            Photo tempPhoto;
            while (rs.next()) {

				tempPhoto = new Photo();
				
				tempPhoto.setIdPhoto(rs.getInt("id_photo"));
				tempPhoto.setIdOrder(rs.getInt("id_order"));
				tempPhoto.setFileName(rs.getString("file_name"));
				tempPhoto.setIdService(rs.getInt("id_service"));
				tempPhoto.setFileType(rs.getString("file_type"));
				
				photos.add(tempPhoto);
            }
			
		}catch (SQLException e) {
			System.out.println("Error - download list of orders");
            e.printStackTrace();
        }
		
		return photos;
	}
	
	
//	public Photo getPhotoByOrderId(int id) {
//	}
}
