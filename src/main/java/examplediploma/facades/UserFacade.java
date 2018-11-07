package examplediploma.facades;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.User;

public class UserFacade {
	
	private UserDao userDao;
	
	{
		userDao = new DefaultUserDao();
	}
	
	// TODO Convert User to UserData object
	public User getUserById(int id) {
		if (id > 0) {
			return userDao.getUserById(id);
		}
		throw new IllegalArgumentException();
	}
	
	public boolean saveUser(User user) {
		// validate user
		return userDao.saveUser(user);
	}

}
