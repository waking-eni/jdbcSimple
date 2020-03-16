package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class AddPerson {
	
	private Connection con = null;
	Statement stmt = null;
	
	public AddPerson() {
		
	}
	
	public void add(String name, String surname) {
		
		String sql = "INSERT INTO person (name, surname) VALUES (?, ?) ;";
		
		try {
			con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setString(2, surname);
			int numRowsAffected = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close statement
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//close connection
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
