package examplediploma.groupacdc.dao;

import java.util.List;

import examplediploma.groupacdc.models.TourData;
import examplediploma.groupacdc.models.UserData;

public interface UserDao {
	
	UserData getUserById(int id);
	List<TourData> getToursForUser(int userId);
}
