package jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.omg.PortableInterceptor.INACTIVE;

public class Test2 {
	public static void main(String[] args) throws IOException, JSONException {
		
		String iptUrl = 
				"http://domair.interpark.com/api/booking/airJourney.do?"
				+ "format=json&dep=GMP&arr=CJU&depDate=20190829&"
				+ "adt=1&chd=0&inf=0&tripDivi=0&airlineCode=KE&siteCode=";
		
		//정보 추출
		System.out.println("================정보추출================");
		JSONArray infoArr = readJsonFromUrl(iptUrl)
								.getJSONObject("replyAvailFare")
								.getJSONArray("availFareSet");
		JSONObject info = infoArr
							.getJSONObject(0)
							.getJSONObject("segFare");
		System.out.println("항공사 코드: " + info.get("carCode"));
		System.out.println("항공사 이름: " + info.get("carDesc"));
		System.out.println("출발 날짜: " + info.get("depDate"));
		System.out.println("출발 시간: " + info.get("depTime"));
		System.out.println("항공편: " + info.get("mainFlt"));
		
		//가격정보
		System.out.println("=================가격정보================");
		JSONObject json5 = info.getJSONArray("classDetail").getJSONObject(0);
		System.out.println(Integer.parseInt(json5.get("fareOrigin").toString()) + 1000 + "원");
		
		//항공권 정보
		System.out.println("================항공권정보================");
		List<JSONObject> tripInfo = new ArrayList<JSONObject>();
		System.out.println(infoArr.length());
		
		for (int i = 0; i < infoArr.length(); i++) {
			tripInfo.add(infoArr.getJSONObject(i).getJSONObject("segFare"));
		}
		
		System.out.println(tripInfo.get(0));
		System.out.println(tripInfo.get(0).get("carCode"));
		System.out.println(tripInfo.get(0).get("mainFlt"));
		
		System.out.println("항공사 코드");
		System.out.println("항공사 이름");
		System.out.println("항공편");
		System.out.println("출발 도시");
		System.out.println("출발 도시이름");
		System.out.println("출발 날짜");
		System.out.println("출발 요일");
		System.out.println("출발 시간");
		System.out.println("도착 도시");
		System.out.println("도착 도시이름");
		System.out.println("도착 날짜");
		System.out.println("도착 요일");
		System.out.println("도착 시간");
	}
	
	private static String readAll(Reader r) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = r.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		
		try {
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(br);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
}
