package bean.DB_bean;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Shelter implements Serializable{
	private int no;
	private String name;
	private String name_kana;
	private String address;
	private double latitude;
	private double longitude;
	private String tel;
	private int capacity;
	private String distance_km;

	public String getDistance_km() {
		return distance_km;
	}

	public void setDistance_km(double distance_km) {
         DecimalFormat df = new DecimalFormat("#.##");
		this.distance_km = df.format(distance_km);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_kana() {
		return name_kana;
	}

	public void setName_kana(String nama_kana) {
		this.name_kana = nama_kana;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
