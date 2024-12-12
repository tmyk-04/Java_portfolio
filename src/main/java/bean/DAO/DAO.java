package bean.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import bean.DB_bean.Shelter;
import bean.DTO.ShelterDTO;

public class DAO {

	private String URL = "DB_URL";
	private String USER = "DB_USER";
	private String PASS = "DB_PASS";
	
	public DAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public ShelterDTO selectShelter(String latitude, String longitude, String[] type) {
		ShelterDTO dto = new ShelterDTO();
		String bool = "AND ";
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *,");
		sql.append("6371 * ACOS(");
		sql.append("COS(RADIANS(?)) *");
		sql.append("COS(RADIANS(latitude)) *");
		sql.append("COS(RADIANS(longitude) -");
		sql.append("RADIANS(?)) + SIN(RADIANS(?)) *");
		sql.append("SIN(RADIANS(latitude))) AS distance_km ");
		sql.append("FROM shelter ");
		sql.append("WHERE no IN ");
		sql.append("(SELECT shelter_key ");
		sql.append("FROM disaster_type ");
		sql.append("WHERE ");
		if (Arrays.asList(type).contains("1")) sql.append("flood = 1 " + bool);
		if (Arrays.asList(type).contains("2")) sql.append("landslide = 1 " + bool);
		if (Arrays.asList(type).contains("3")) sql.append("high_tide = 1 " + bool);
		if (Arrays.asList(type).contains("4")) sql.append("earthquake = 1 " + bool);
		if (Arrays.asList(type).contains("5")) sql.append("tsunami = 1 " + bool);
		if (Arrays.asList(type).contains("6")) sql.append("fire = 1 " + bool);
		if (Arrays.asList(type).contains("7")) sql.append("inland_flooding = 1 " + bool);
		if (Arrays.asList(type).contains("8")) sql.append("volcanic_eruption = 1 " + bool);
		int boolsize = bool.length();
		int sqlsize = sql.length();
		sql.delete(sqlsize-boolsize, sqlsize);
		sql.append(")");
		sql.append("ORDER BY distance_km ASC ");
		sql.append("LIMIT 3;");
		String sqlstr = sql.toString();
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				 PreparedStatement ps = con.prepareStatement(sqlstr);) {
				ps.setString(1, latitude);
				ps.setString(2, longitude);
				ps.setString(3, latitude);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Shelter sb = new Shelter();
					sb.setName(rs.getString("name"));
					sb.setName_kana(rs.getString("name_kana"));
					sb.setAddress(rs.getString("address"));
					sb.setLatitude(rs.getDouble("latitude"));
					sb.setLongitude(rs.getDouble("longitude"));
					sb.setTel(rs.getString("tel"));
					sb.setCapacity(rs.getInt("capacity"));
					sb.setDistance_km(rs.getDouble("distance_km"));
					dto.add(sb);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return dto;
	}
}

