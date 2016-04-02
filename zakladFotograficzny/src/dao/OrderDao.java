package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Order;
import util.DbUtil;

public class OrderDao {

	private Connection connection;

	public OrderDao() {
		connection = DbUtil.getConnection();
	}

	public boolean createOrder(Order order) {

		boolean status=false;
		
		System.out.println("OrderDao: create order...");

		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `order`"
					+ " (`id_order`, `id_status`, `creation_time`, `last_edit_time`, `adding_information`, `id_payment`, `id_shippment`, `id_department`)"
					+ " VALUES  "
					+ "(NULL, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ?, ?);");
			
			ps.setInt(1, order.getIdStatus());
			ps.setString(2, order.getAddedInfo());
			ps.setInt(3, order.getIdPayment());
			ps.setInt(4, order.getIdShippment());
			ps.setInt(5, order.getIdDepartment());
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("Creating order sql error");
			e.printStackTrace();
		}
		
		System.out.println("Creating order succesful");
		return true;

	}

}
