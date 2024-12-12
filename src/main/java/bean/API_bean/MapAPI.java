package bean.API_bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class MapAPI implements Serializable{
	private String latitude;
	private String longitude;
	public MapAPI() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void getGeocode(String address) throws UnsupportedEncodingException {
		String encodedAddress = URLEncoder.encode(address, "UTF-8"); // 日本語に対応するためエンコード
        String urlString = "https://nominatim.openstreetmap.org/search?q=" + encodedAddress + "&format=json&addressdetails=1";      
        StringBuilder result = new StringBuilder();
        try {
			@SuppressWarnings("deprecation")
			URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // サーバからデータ取得目的のためGET
            conn.setRequestMethod("GET");
            // アプリ名とメールアドレスを指定
            conn.setRequestProperty("User-Agent", "Test_app/1.0 (t.watanabe.tmyk@gmail.com)");
            // apiレスポンスをjson形式で受け取り、1行ずつ読み込む
            // conn.getInputStream() httpレスポンスの入力ストリームを取得
            // new InputStramReader() ↑のバイトストリームを文字ストリームに変換
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            // 1行ずつ読み込む 無限ループにならないよう注意
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            
            JSONArray jsonArray = new JSONArray(result.toString());
            if (jsonArray.length() > 0) {
            	// 最初の検索結果が最も関連性が高いためjsonArray.getJSONObject(0)のみ取得
                JSONObject location = jsonArray.getJSONObject(0);
                String latitude = location.getString("lat");
                String longitude = location.getString("lon");
                setLatitude(latitude);
                setLongitude(longitude);
            } else {
            	setLatitude(null);
                setLongitude(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
