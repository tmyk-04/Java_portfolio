package bean.DB_bean;

import java.io.Serializable;
import java.util.HashMap;

public class DisasterType implements Serializable{
	private HashMap<String, String> map = new HashMap<String, String>();
	private int no;
	private int shelter_key;
	private boolean flood;
	private boolean landslide;
	private boolean high_tide;
	private boolean earthquake;
	private boolean tsunami;
	private boolean fire;
	private boolean inland_flooding;
	private boolean volcanic_eruption;
	
	public DisasterType() {
		// TODO 自動生成されたコンストラクター・スタブ
		map.put("1", "洪水");
		map.put("2", "崖崩れ、土石流及び地滑り");
		map.put("3", "高潮");
		map.put("4", "地震");
		map.put("5", "津波");
		map.put("6", "大規模な火事");
		map.put("7", "内水氾濫");
		map.put("8", "火山現象");
	}
	
	public String getMap(String key) {
		return map.get(key);
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getShelter_key() {
		return shelter_key;
	}
	public void setShelter_key(int shelter_key) {
		this.shelter_key = shelter_key;
	}
	public boolean isFlood() {
		return flood;
	}
	public void setFlood(boolean flood) {
		this.flood = flood;
	}
	public boolean isLandslide() {
		return landslide;
	}
	public void setLandslide(boolean landslide) {
		this.landslide = landslide;
	}
	public boolean isHigh_tide() {
		return high_tide;
	}
	public void setHigh_tide(boolean high_tide) {
		this.high_tide = high_tide;
	}
	public boolean isEarthquake() {
		return earthquake;
	}
	public void setEarthquake(boolean earthquake) {
		this.earthquake = earthquake;
	}
	public boolean isTsunami() {
		return tsunami;
	}
	public void setTsunami(boolean tsunami) {
		this.tsunami = tsunami;
	}
	public boolean isFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	public boolean isInland_flooding() {
		return inland_flooding;
	}
	public void setInland_flooding(boolean inland_flooding) {
		this.inland_flooding = inland_flooding;
	}
	public boolean isVolcanic_eruption() {
		return volcanic_eruption;
	}
	public void setVolcanic_eruption(boolean volcanic_eruption) {
		this.volcanic_eruption = volcanic_eruption;
	}
}
