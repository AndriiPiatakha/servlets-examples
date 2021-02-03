package dao.dao_3.dao;

import java.util.List;

import dao.dao_3.models.UserModel;

public interface UserDao {
	
	UserModel getUserById(int id);

	List<UserModel> getAllUsers();
	
	boolean saveUser(UserModel user);
	
	boolean updateUser(UserModel user);
}
