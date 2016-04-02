package dao;

import java.sql.*;
import model.Login;
import util.DbUtil;  

public class LoginDao {
private Connection connection;
	
	public LoginDao(){
		connection = DbUtil.getConnection();
	}
	
	public boolean validate(Login login){  
		boolean status=false; 
		
		try{  

		System.out.println("LoginDao: Validation...");
		              
		PreparedStatement ps=connection.prepareStatement(  
		    "select * from user where login=? and password=?");  
		  
		ps.setString(1, login.getLogin());
		ps.setString(2, login.getPassword());  
		              
		ResultSet rs=ps.executeQuery();  		
		status=rs.next();  
		              
		}catch(Exception e){
		}  
		
		System.out.println("LoginDao: status: " + status);
		return status;  
		  
	}

}
