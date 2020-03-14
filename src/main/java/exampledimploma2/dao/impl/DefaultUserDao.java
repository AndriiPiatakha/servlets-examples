package exampledimploma2.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exampledimploma2.dao.UserDao;
import exampledimploma2.models.UserData;

public class DefaultUserDao implements UserDao {
	
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
	private static final String URL = "jdbc:mysql://localhost:3306/group10_db?useUnicode=true&useJDBCCompliantTimezoneShift=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	@Override
	public UserData getUserById(int id) {
		UserData user = null;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
			
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new UserData();
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setId(rs.getInt("id"));
					// user.setRole(roleDao.getRoleById(rs.getInt("role_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
