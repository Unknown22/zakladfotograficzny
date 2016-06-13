package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.PhotoService;
import util.DbUtil;

public class PhotoServiceDao {
	private Connection connection;

	public PhotoServiceDao() {
		connection = DbUtil.getConnection();
	}
	
	public PhotoService getPhotoServiceById(int id)
	{
		PhotoService phService=new PhotoService();
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from photo_service where id_service='"+id+"'");
            while (rs.next()){
            	phService.setId_service(rs.getInt("id_service"));
            	phService.setCopies(rs.getInt("copies"));
            	phService.setId_photo_format(rs.getInt("id_photo_format"));
            	phService.setId_sealing(rs.getInt("id_sealing"));
            	phService.setId_retouch(rs.getInt("id_retouch"));
            }
		}catch (SQLException e) {
			System.out.println("Error - download PhotoService");
            e.printStackTrace();
        }
		return phService;
	}
}
