package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Help;
import util.DbUtil;

public class HelpDao {

	
	private Connection connection;

	public HelpDao() {
		connection = DbUtil.getConnection();
	}

	public boolean sendHelp(Help help) {
		
		System.out.println("HelpDao: create help message...");

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `help` (`id_help`, `email`, `message`) VALUES (NULL,?, ?);");
			
			ps.setString(1, help.getEmail());
			ps.setString(2, help.getMessage());
			
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("Creating order sql error");
			e.printStackTrace();
			return false;
		}
		
		System.out.println("Creating help message succesful");
		return true;
	}
}
