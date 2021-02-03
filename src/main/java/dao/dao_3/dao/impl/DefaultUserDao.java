package dao.dao_3.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.dao_3.dao.UserDao;
import dao.dao_3.models.UserModel;
import dao.dao_3.utils.DbUtils;

public class DefaultUserDao implements UserDao {

	@Override
	public UserModel getUserById(int id) {
		try (var conn = DbUtils.getConnection();
				var ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("==========");
					var user = new UserModel();
					user.setId(rs.getInt("id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		return null;
	}

	@Override
	public boolean saveUser(UserModel user) {
		return false;
	}

	@Override
	public boolean updateUser(UserModel user) {
		return false;
	}

}
