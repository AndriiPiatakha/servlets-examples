package examplediploma.facades;

import examplediploma.dao.UserDao;
import examplediploma.dao.impl.DefaultUserDao;
import examplediploma.models.UserData;

public class UserFacade {
	
	private UserDao userDao;
	
	{
		userDao = new DefaultUserDao();
	}
	
	// TODO Convert User to UserData object
	public UserData getUserById(int id) {
		if (id > 0) {
			return userDao.getUserById(id);
		}
		throw new IllegalArgumentException();
	}
	
	public boolean saveUser(UserData user) {
		// validate user
		return userDao.saveUser(user);
	}

}
