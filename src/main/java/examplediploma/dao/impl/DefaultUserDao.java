package examplediploma.dao.impl;

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
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return null;
	}

}
