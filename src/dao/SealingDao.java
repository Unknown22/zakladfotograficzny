package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class SealingDao {

	private Connection connection;

	public SealingDao() {
		connection = DbUtil.getConnection();
	}
	
	public float getSealingPrice(int id)
	{
		float income=0;
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from sealing where id_sealing='"+id+"'");
            
            while (rs.next()){
            	float price;
            	price=rs.getFloat("price");
            	income+=price;
            }
		}catch (SQLException e) {
			System.out.println("Error - download sealing");
            e.printStackTrace();
        }
		return income;
	}
}