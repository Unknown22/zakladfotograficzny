package dao;

import java.sql.*;
import model.Login;
import model.Order;
import util.DbUtil;  

public class LoginDao {
private Connection connection;
	
	public LoginDao(){
		connection = DbUtil.getConnection();
	}
	
	public int authorization(Login login){  
		boolean status=false; 
		
		try{  

		System.out.println("LoginDao: Validation...");
		              
		PreparedStatement ps=connection.prepareStatement(  
		    "select * from user where login=? and password=?");  
		  
		ps.setString(1, login.getLogin());
		ps.setString(2, login.getPassword());  
		              
		ResultSet rs=ps.executeQuery();  		
		if(status = rs.next()){
			System.out.println("Wyrzut z LoginDAO" + rs.getInt("id_account_type"));
        	login.setAuthorization(rs.getInt("id_account_type"));
		}

		}catch(Exception e){
		}  
		
		System.out.println("LoginDao: status: " + status);
		return login.getAuthorization();
		  
	}

}
