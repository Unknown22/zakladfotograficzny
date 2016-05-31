package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Help;
import model.User;
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
			System.out.println("Creating help message sql error");
			e.printStackTrace();
			return false;
		}
		
		System.out.println("Creating help message succesful");
		
		return true;
	}
	
	public Boolean deleteHelp(int id_help) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from help where id_help=?");
            preparedStatement.setInt(1, id_help);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
	
	public List<Help> getAllHelpMessage(){
		
		List<Help> help_all = new ArrayList<Help>();
		
		try{
			
			Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery("select * from help");
	        
	        while (rs.next()){
	        	
	        	Help help = new Help();
	        	
	        	help.setId_help(rs.getInt("id_help"));

	        	help.setEmail(rs.getString("email"));
	        	help.setMessage(rs.getString("message"));

	        	help_all.add(help);
	        	
	        }
			
		}catch (SQLException e) {
			System.out.println("Error with download list of help messages");
	        e.printStackTrace();
	    }
		
		return help_all;
		
	}
}
