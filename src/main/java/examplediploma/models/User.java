package examplediploma.models;

import java.util.Date;
import java.util.List;

public class User {
	
	private int id;
	private String name;
	private String lastName;
	private Date dob;
	private List<Tour> tours;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Tour> getTours() {
		return tours;
	}
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + ", dob=" + dob + ", tours=" + tours + "]";
	}
	

}
