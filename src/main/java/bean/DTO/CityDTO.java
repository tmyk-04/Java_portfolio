package bean.DTO;

import java.io.Serializable;
import java.util.ArrayList;

import bean.DB_bean.City;

public class CityDTO implements Serializable{
private ArrayList<City> list;
	
	public CityDTO() {
		list = new ArrayList<City>();
	}
	
	public void add(City ct) {
		list.add(ct);
	}
	
	public City get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
}
