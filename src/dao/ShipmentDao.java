package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class ShipmentDao {

	private Connection connection;

	public ShipmentDao() {
		connection = DbUtil.getConnection();
	}
	
	public float getshipmentPrice(int id)
	{
		float income=0;
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from shipment where id_shipment='"+id+"'");
            
            while (rs.next()){
            	float price;
            	price=rs.getFloat("price");
            	income+=price;
            }
		}catch (SQLException e) {
			System.out.println("Error - download shipment");
            e.printStackTrace();
        }
		return income;
	}
}
