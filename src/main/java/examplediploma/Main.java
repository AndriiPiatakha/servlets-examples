package examplediploma;

import java.util.List;

import examplediploma.dao.TourDao;
import examplediploma.dao.impl.DefaultTourDao;
import examplediploma.models.TourData;
import examplediploma.models.UserData;

public class Main {
	
	public static void main(String[] args) {
		TourDao tourDao = DefaultTourDao.getInstance();
		UserData user = new UserData();
		user.setId(1);
		
		List<TourData> toursForUser = tourDao.getToursForUser(user);
		
		for (TourData tourData : toursForUser) {
			System.out.println(tourData);
		}
	}

}
