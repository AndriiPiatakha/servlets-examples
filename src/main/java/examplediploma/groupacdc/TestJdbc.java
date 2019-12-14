package examplediploma.groupacdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import examplediploma.groupacdc.dao.DefaultUserDao;
import examplediploma.groupacdc.dao.impl.UserDao;
import examplediploma.groupacdc.models.UserData;


public class TestJdbc {
	
	// ============ Queries
	private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/mytestdb";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		try (Connection conn = DriverManager.getConnection(URL + PARAMS, USER, PASSWORD); 
//				PreparedStatement statement = conn.prepareStatement(SELECT_USER);) {
//			
//			statement.setInt(1, 1);
//			try (ResultSet rs = statement.executeQuery();) {
//				if (rs.next()) {
//					System.out.println(rs.getString("first_name"));
//				}
//			}
//		}
		
		UserDao userDao = new DefaultUserDao();
		UserData user = userDao.getUserById(1);
		System.out.println(user);
	}

}
