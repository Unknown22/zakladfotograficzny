package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public List<User> getAllUsers(){
		
		List<User> users = new ArrayList<User>();
		
		try{
			
			Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from user");
            
            while (rs.next()){
            	
            	User user = new User();
            	
            	user.setId_user(rs.getInt("id_user"));

            	user.setFirstname(rs.getString("firstname"));
            	user.setLastname(rs.getString("lastname"));
            	user.setEmail(rs.getString("email"));
            	user.setLogin(rs.getString("login"));
            	user.setIdAccountType(rs.getInt("id_account_type"));
            	
            	users.add(user);
            	
            }
			
		}catch (SQLException e) {
			System.out.println("Error - download list of users");
            e.printStackTrace();
        }
		
		return users;
		
	}
	
	
	public Boolean deleteUser(int id_user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from user where id_user=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id_user);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
	
	
}
