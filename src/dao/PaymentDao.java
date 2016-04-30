package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DbUtil;

public class PaymentDao {
	private Connection connection;

	public PaymentDao() {
		connection = DbUtil.getConnection();
	}
	
	public float getAllIncome()
	{
		float income=0;
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from payment");
            
            while (rs.next()){
            	float price;
            	price=rs.getFloat("price");
            	income+=price;
            }
		}catch (SQLException e) {
			System.out.println("Error - download payment");
            e.printStackTrace();
        }
		return income;
	}
}
