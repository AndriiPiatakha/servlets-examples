package examplediploma.groupacdc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import examplediploma.groupacdc.dao.UserDao;
import examplediploma.groupacdc.dbutils.DbHelper;
import examplediploma.groupacdc.models.TourData;
import examplediploma.groupacdc.models.UserData;


public class DefaultUserDao implements UserDao {

	private static final String SELECT_USER = "SELECT * FROM users WHERE id = ?";
	private static final String GET_TOURS_FOR_USER = 
			"SELECT t.id, t.tour_name, "
			+ "t.tour_price FROM tours t \r\n" + 
			"JOIN orders o ON t.id = o.tour_id\r\n" + 
			"WHERE o.user_id = ?;";
	private static DefaultUserDao instance;
	private DbHelper dbHelper;
	
	private DefaultUserDao() {
		dbHelper = DbHelper.getInstance();
	}
	
	public synchronized static UserDao getInstance() {
		if (instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}
	
	@Override
	public UserData getUserById(int id) {
		try {
			UserData userData = null;
			
			try (Connection conn = dbHelper.getConnection(); 
					PreparedStatement statement = conn.prepareStatement(SELECT_USER);) {
				
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery();) {
					if (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("id"));
						userData.setFirstName(rs.getString("first_name"));
						int isBlocked = rs.getInt("is_blocked");
						if (isBlocked == 1) {
							userData.setBlocked(true);
						}
						userData.setTours(getToursForUser(id));
					}
				}
			}
			return userData;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<TourData> getToursForUser(int userId) {
		List<TourData> tours = new ArrayList<TourData>();
		try (Connection conn = dbHelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_TOURS_FOR_USER)) {
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();
				tourData.setId(rs.getInt("id"));
				tourData.setTourName(rs.getString("tour_name"));
				tourData.setPrice(rs.getInt("tour_price"));
				tours.add(tourData);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tours;
	}

}
