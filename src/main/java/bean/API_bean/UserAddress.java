package bean.API_bean;

import java.io.Serializable;

public class UserAddress implements Serializable {
	private String address;
	private String latitude;
	private String longitude;
	private String error;
	
	public UserAddress() {
		
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLatitude() {
		return this.latitude;
		
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
