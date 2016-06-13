package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class PhotoFormatDao {

	private Connection connection;

	public PhotoFormatDao() {
		connection = DbUtil.getConnection();
	}
	
	public float getRetouchPrice(int id)
	{
		float income=0;
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from photo_format where id_photo_format='"+id+"'");
            
            while (rs.next()){
            	float price;
            	price=rs.getFloat("price");
            	income+=price;
            }
		}catch (SQLException e) {
			System.out.println("Error - photo_format retouch");
            e.printStackTrace();
        }
		return income;
	}
}