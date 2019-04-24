package examplediploma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.dbutils.DataSourceUtils;
import examplediploma.dao.UserDao;
import examplediploma.models.UserData;

public class DefaultUserDao implements UserDao {
	
	public static final String SELECT_USER_BY_ID_QUERY = "SELECT * FROM user WHERE user.id = ?";
	public static final String INSERT_USER_WITH_NAME_ONLY = "INSERT INTO user (`name`) VALUES (?)";

	private static DefaultUserDao instance;
	private DataSource ds;
	
	private DefaultUserDao() {
	}
	
	{
		this.ds = DataSourceUtils.getDataSource();
	}
	
	public static synchronized DefaultUserDao getUserDaoInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	@Override
	public UserData getUserById(int id) {
		UserData user = new UserData();
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
	public List<UserData> getAllUsers() {
		List<UserData> users = new ArrayList<>();
		// get connection
		// get statement
		// execute query 
		// get result set
		// while loop 
//		while (rs.next()) {
//			User user = new User();
//			user.setId(rs.getInt("id"));
//			users.add(user);
//		}
//		
		return users;
	}

	@Override
	public boolean saveUser(UserData user) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(INSERT_USER_WITH_NAME_ONLY);
			ps.setString(1, user.getName());
			// TODO change sql query to insert email and other fields
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
