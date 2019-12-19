package examplediploma.groupacdc.models;

import java.util.List;

public class UserData {
	
	private int id;
	private String firstName;
	private boolean isBlocked;
	private List<TourData> tours;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	
	
	public List<TourData> getTours() {
		return tours;
	}
	public void setTours(List<TourData> tours) {
		this.tours = tours;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", isBlocked=" + isBlocked + ", tours=" + tours
				+ "]";
	}
	
	
	
	
	
	

}
