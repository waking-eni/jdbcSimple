package tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
	
	public static void getPersons(ResultSet rs) throws SQLException {
		while(rs.next()) {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("Person ID: " + rs.getInt("id") + " ");
			buffer.append("Person NAME: " + rs.getString("name") + " ");
			buffer.append("Person SURNAME: " + rs.getString("surname") + " ");
			
			System.out.println(buffer.toString());
			
		}
	}

}
