package examplediploma.dao;

import java.util.List;

import examplediploma.models.User;


public interface UserDao {
	
	User getUserById(int id);
	List<User> getAllUsers();

}
