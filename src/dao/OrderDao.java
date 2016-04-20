package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.User;
import util.DbUtil;

public class OrderDao {

	private Connection connection;

	public OrderDao() {
		connection = DbUtil.getConnection();
	}

	public boolean createOrder(Order order) {
		
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
			return false;
		}
		
		System.out.println("Creating order succesful");
		return true;

	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `order` WHERE `order`.`id_status`=1");
            
            while (rs.next()){
            	
            	Order order = new Order();
            	
            	order.setId(rs.getInt("id_order"));
            	order.setIdStatus(rs.getInt("id_status"));
            	order.setCreationTime(rs.getString("creation_time"));
            	order.setLastEditTime(rs.getString("last_edit_time"));
            	order.setAddedInfo(rs.getString("adding_information"));
            	order.setIdPayment(rs.getInt("id_payment"));
            	order.setIdShippment(rs.getInt("id_shippment"));
            	order.setIdDepartment(rs.getInt("id_department"));
            	
            	orders.add(order);
            	
            }
			
		}catch (SQLException e) {
			System.out.println("Error - download list of orders");
            e.printStackTrace();
        }
		
		return orders;

	}

	
	public Boolean deleteOrder(int id_order) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from `order` where `id_order`=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id_order);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

	
	public Order showOrder(int id_order) {
		Order order = new Order();
		
		try{
			
			Statement statement = connection.createStatement();
			String st = "SELECT * FROM `order` WHERE `order`.`id_order`=" + id_order;
            ResultSet rs = statement.executeQuery(st);
            
            while (rs.next()){
            	
            	order.setId(rs.getInt("id_order"));
            	order.setIdStatus(rs.getInt("id_status"));
            	order.setCreationTime(rs.getString("creation_time"));
            	order.setLastEditTime(rs.getString("last_edit_time"));
            	order.setAddedInfo(rs.getString("adding_information"));
            	order.setIdPayment(rs.getInt("id_payment"));
            	order.setIdShippment(rs.getInt("id_shippment"));
            	order.setIdDepartment(rs.getInt("id_department"));
            	
            }
			
		}catch (SQLException e) {
			System.out.println("Error - download more informations about order");
            e.printStackTrace();
        }
		
		return order;

	}

}
