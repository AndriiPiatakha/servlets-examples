package examplediploma.groupacdc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import examplediploma.groupacdc.dao.impl.UserDao;
import examplediploma.groupacdc.models.UserData;

public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/mytestdb";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	
	@Override
	public UserData getUserById(int id) {
		try {
			UserData userData = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection(URL + PARAMS, USER, PASSWORD); 
					PreparedStatement statement = conn.prepareStatement(SELECT_USER);) {
				
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery();) {
					if (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("first_name"));
						int isBlocked = rs.getInt("is_blocked");
						if (isBlocked == 1) {
							userData.setBlocked(true);
						}
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
