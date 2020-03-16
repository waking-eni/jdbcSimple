package jdbcProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;

import database.DBConnection;
import tables.Person;
import action.AddPerson;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame instance = null;
	
	private Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
		
	
	private MainFrame() {
		
	}
	
	public void initialize() {
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM person");
			
			Person.getPersons(rs);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close result set
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Do you want to add a Person?");
		String answer = input.nextLine();
		
		if(answer.equalsIgnoreCase("yes")) {
			System.out.println("Enter NAME: ");
			String personName = input.nextLine();
			System.out.println("Enter SURNAME: ");
			String personSurname = input.nextLine();
			
			AddPerson addPerson = new AddPerson();
			addPerson.add(personName, personSurname);
			
			System.exit(1);
		} else {
			System.exit(1);
		}
		
	}
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
			instance.initialize();
		}
		return instance;
	}
	
	
}
