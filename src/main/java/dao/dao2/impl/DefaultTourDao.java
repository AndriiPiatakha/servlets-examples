package dao.dao2.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import dao.dao2.TourDao;
import dao.dbutils.DataSourceUtils;
import dao.models.Tour;
import dao.models.User;

public class DefaultTourDao implements TourDao {
	
	private DataSource ds;
	
	{
		ds = DataSourceUtils.getDataSource();
	}

	@Override
	public Tour getTourById(int id) {
		try {
			Connection conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveTour(Tour tour) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tour> getAllTours() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> getToursForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tour> getToursWithinDays(int range) {
		// TODO Auto-generated method stub
		return null;
	}

}
