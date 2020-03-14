package exampledimploma2.demo;

import exampledimploma2.dao.UserDao;
import exampledimploma2.dao.impl.DefaultUserDao;
import exampledimploma2.models.UserData;

public class Demo {
	
	public static void main(String[] args) {
		UserDao userDao = new DefaultUserDao();
		UserData user = userDao.getUserById(1);
		System.out.println(user);
	}

}
