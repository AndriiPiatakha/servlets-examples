package dao.dao_3;

import dao.dao_3.dao.UserDao;
import dao.dao_3.dao.impl.DefaultUserDao;
import dao.dao_3.models.UserModel;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = new DefaultUserDao();
		UserModel user = userDao.getUserById(1);
		System.out.println(user);
	}
}
