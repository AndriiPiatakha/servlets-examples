package examplediploma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import examplediploma.dao.TourDao;
import examplediploma.dbutils.DbConnectionUtils;
import examplediploma.models.TourData;
import examplediploma.models.UserData;


public class DefaultTourDao implements TourDao {

	private static final String TOUR_ID_FIELD = "id";
	private static final String TOUR_NAME_FIELD = "tourName";

	public static final String GET_TOURS_FOR_USER = 
			"SELECT t.id, t.tourname from users_tours ut JOIN tours t ON ut.idtour = "
			+ "t.id WHERE ut.iduser = ?;";
	
	private static DefaultTourDao instance;
	
	private DefaultTourDao() {
	}
	
	public static synchronized DefaultTourDao getInstance() {
		if (instance == null) {
			instance = new DefaultTourDao();
		}
		return instance;
	}
	
	@Override
	public List<TourData> getToursForUser(UserData user) {
		try (Connection conn = DbConnectionUtils.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(GET_TOURS_FOR_USER)) {
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				return Collections.emptyList();
			} else {
				List<TourData> tours = new ArrayList<>();
				do {
					TourData tourData = new TourData();
					tourData.setId(rs.getInt(TOUR_ID_FIELD));
					tourData.setName(rs.getString(TOUR_NAME_FIELD));
					tours.add(tourData);
				} while (rs.next());
				return tours;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}


}
