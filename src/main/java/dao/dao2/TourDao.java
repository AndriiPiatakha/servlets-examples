package dao.dao2;

import java.util.List;

import dao.models.Tour;
import dao.models.User;

public interface TourDao {
	Tour getTourById(int id);
	boolean saveTour(Tour tour);
	List<Tour> getAllTours();
	List<Tour> getToursForUser(User user);
	List<Tour> getToursWithinDays(int range);
}
