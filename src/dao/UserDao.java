package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;
import model.User;

public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}
	
	public boolean createUser(User user){
		System.out.println("UserDao: create user...");

		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO `user` "
					+ "(`id_user`, `firstname`, `lastname`, `email`, `login`, `password`, `id_account_type`, `id_department`)"
					+ " VALUES "
					+ "(NULL, ?, ?, ?, ?, ?, ?, ?);");
			
			
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getLogin());
			ps.setString(5, user.getPassword());
			ps.setInt(6, user.getIdAccountType());
			ps.setInt(7, user.getIdDepartment());
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("Creating user sql error");
			e.printStackTrace();
		}
		
		System.out.println("Creating user succesful");
		return true;
	}
}
