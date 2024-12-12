package bean.DTO;

import java.io.Serializable;
import java.util.ArrayList;

import bean.DB_bean.Shelter;

public class ShelterDTO implements Serializable{
private ArrayList<Shelter> list;
	
	public ShelterDTO() {
		list = new ArrayList<Shelter>();
	}
	
	public void add(Shelter sb) {
		list.add(sb);
	}
	
	public Shelter get(int i) {
		return list.get(i);
	}
	
	public int size() {
		return list.size();
	}
}
