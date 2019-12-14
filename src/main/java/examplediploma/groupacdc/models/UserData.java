package examplediploma.groupacdc.models;

public class UserData {
	
	private int id;
	private String firstName;
	private boolean isBlocked;
	
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
	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", isBlocked=" + isBlocked + "]";
	}
	
	
	
	

}
