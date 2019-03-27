package lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionLesson {
	
	private static final String JDBC_MYSQL_LOCALHOST = "jdbc:mysql://localhost:3306/travel_agency";

	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection conn = 
				DriverManager.getConnection(
						JDBC_MYSQL_LOCALHOST,
						"root",
						"root")) {
			System.out.println("We have connection! Yeeeeeh");
			
		}
		
	}

}
