package examplediploma.groupacdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import examplediploma.groupacdc.dao.UserDao;
import examplediploma.groupacdc.dao.impl.DefaultUserDao;
import examplediploma.groupacdc.models.TourData;
import examplediploma.groupacdc.models.UserData;


public class TestJdbc {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDao userDao = DefaultUserDao.getInstance();
		UserData user = userDao.getUserById(1);
		System.out.println(user);
		
		List<TourData> toursForUser = userDao.getToursForUser(1);
		System.out.println(toursForUser);
	}

}
