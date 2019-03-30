package examplediploma.dao;

import java.util.List;

import examplediploma.models.TourData;
import examplediploma.models.UserData;

public interface TourDao {

	List<TourData> getToursForUser(UserData user);
	
}
