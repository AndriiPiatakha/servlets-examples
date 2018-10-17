package dao.models;

import java.util.List;

public class Region {
	private int id;
	private String name;
	private Country country;
	private List<City> cities;
}
