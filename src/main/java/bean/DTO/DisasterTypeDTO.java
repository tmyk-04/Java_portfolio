package bean.DTO;

import java.io.Serializable;
import java.util.ArrayList;

import bean.DB_bean.DisasterType;

public class DisasterTypeDTO implements Serializable{
private ArrayList<DisasterType> list;
	
	public DisasterTypeDTO() {
		list = new ArrayList<DisasterType>();
	}
	
	public void add(DisasterType dt) {
		list.add(dt);
	}
	
	public DisasterType get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
}
