package exampledimploma2.demo;

import exampledimploma2.dao.UserDao;
import exampledimploma2.dao.impl.DefaultUserDao;
import exampledimploma2.models.Role;
import exampledimploma2.models.UserData;

public class Demo {
	
	public static void main(String[] args) {
		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = userDao.getUserById(1);
		System.out.println(user);
		
		String roleName = "ADMIN";
		Role role = Role.valueOf(roleName);
		System.out.println(role); 
	}

}
