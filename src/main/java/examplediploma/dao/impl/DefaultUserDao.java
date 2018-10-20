package examplediploma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import dao.dbutils.DataSourceUtils;
import examplediploma.dao.UserDao;
import examplediploma.models.User;

public class DefaultUserDao implements UserDao {
	
	public static final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM user WHERE user.id = ?";
	private DataSource ds;
	
	
	{
		this.ds = DataSourceUtils.getDataSource();
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try (Connection conn = ds.getConnection()) {
			PreparedStatement prepareStatement = conn.prepareStatement(SELECT_USER_BY_ID_QUERY);
			prepareStatement.setInt(1, id);
			ResultSet rs = prepareStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setLastName(rs.getString("last_name"));
				user.setDob(rs.getDate("dob"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}

}
