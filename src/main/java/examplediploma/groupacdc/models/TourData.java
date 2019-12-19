package examplediploma.groupacdc.models;

public class TourData {
	
	private int id;
	private String tourName;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "TourData [id=" + id + ", tourName=" + tourName + ", price=" + price + "]";
	}
	
	

}
