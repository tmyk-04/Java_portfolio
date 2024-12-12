
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.API_bean.MapAPI;
import bean.API_bean.UserAddress;
import bean.DAO.DAO;
import bean.DTO.ShelterDTO;
import bean.SC.Sanitize;
import bean.SC.TypeCheck;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String latitude = "0.0";
	String longitude = "0.0";
	private double jpSouthLat = 25.785506;
	private double jpSouthLon = 127.698318;
	private double jpNorthLat = 45.694597;
	private double jpNorthLon = 142.957792;
	String[] types;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("sanitizedAddress");
//		String sanitizedaddress = address;
		String sanitizedaddress = Sanitize.sanitize(address);
		
		// チェックボックスの値が正しい値か判定
		ArrayList<String> checkedType = new ArrayList<String>();
		checkedType = TypeCheck.typeCheck(request.getParameterValues("disaster"));
		// チェックボックス未チェックの際の処理
		if ((checkedType == null) || (checkedType.isEmpty())) {
			types = new String[]{};
		} else {
			types = checkedType.toArray(new String[0]); // 型Stringを指定
		}
		
		UserAddress userAddress = new UserAddress();
		// フォーム未入力の際
		if (sanitizedaddress == null || sanitizedaddress.trim().isEmpty()) {
			String error = "住所が入力されていません";
			userAddress.setAddress(error);
			request.setAttribute("er", userAddress);
			RequestDispatcher rd = request.getRequestDispatcher("/errorpage.jsp");
			rd.forward(request, response);
			return;
		}
		MapAPI api = new MapAPI();
		api.getGeocode(sanitizedaddress);
		// MapAPIから取得成功時
		if(api.getLatitude() != null && api.getLongitude() != null) {
			latitude = api.getLatitude();
			longitude = api.getLongitude();
		}
		double latD = Double.parseDouble(latitude);
		double lonD = Double.parseDouble(longitude);		
		if ((latitude == null) || (longitude == null)) {
			String error = "取得に失敗しました。";
			userAddress.setAddress(sanitizedaddress);
			userAddress.setError(error);
			userAddress.setLatitude(latitude);
			userAddress.setLongitude(longitude);
			request.setAttribute("ua", userAddress);
			RequestDispatcher rd = request.getRequestDispatcher("/outputShelter.jsp");
			rd.forward(request, response);
			return;
		} else if ((latitude == "0.0") || (longitude == "0.0")) {
			String error = "住所を正しく入力してください。";
			userAddress.setAddress(sanitizedaddress);
			userAddress.setError(error);
			userAddress.setLatitude(latitude);
			userAddress.setLongitude(longitude);
			request.setAttribute("ua", userAddress);
			RequestDispatcher rd = request.getRequestDispatcher("/outputShelter.jsp");
			rd.forward(request, response);
			return;
			
		} else if (((latD >= jpSouthLat) && (lonD >= jpSouthLon)) && ((latD <= jpNorthLat) && (lonD <= jpNorthLon))) {
			// 日本国内の座標
			userAddress.setAddress(sanitizedaddress);
			userAddress.setLatitude(latitude);
			userAddress.setLongitude(longitude);
		} else {
			String error = "日本国外の座標のため出力できません。";
			userAddress.setAddress(sanitizedaddress);
			userAddress.setError(error);
			userAddress.setLatitude(latitude);
			userAddress.setLongitude(longitude);
			request.setAttribute("ua", userAddress);
			RequestDispatcher rd = request.getRequestDispatcher("/outputShelter.jsp");
			rd.forward(request, response);
		}
		
		DAO dao = new DAO();
		ShelterDTO dto_shelter = new ShelterDTO();
		dto_shelter = dao.selectShelter(latitude, longitude, types);
		request.setAttribute("type", types);
		request.setAttribute("ua", userAddress);
		request.setAttribute("dto", dto_shelter);
		RequestDispatcher rd = request.getRequestDispatcher("/outputShelter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
