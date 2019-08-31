package crawlingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {
	public static void main(String[] args) throws IOException, JSONException {
		
		String iptUrl = "http://domair.interpark.com/api/booking/airJourney.do?format=json&dep=GMP&arr=CJU&depDate=20190829&adt=1&chd=0&inf=0&tripDivi=0&airlineCode=KE&siteCode=";
		
		
		
		JSONObject json = readJsonFromUrl(iptUrl);
		System.out.println(json.toString());
		//System.out.println(json.get("replyAvailFare"));
		//System.out.println(json.get("replyHeader"));
		
		System.out.println("===========================================");
		JSONObject json2 = json.getJSONObject("replyAvailFare");
		System.out.println(json2.toString());
		System.out.println(json2.get("availFareSet"));
		System.out.println(json2.get("depDesc"));
		System.out.println(json2.get("arrDesc"));
		
		System.out.println("===========================================");
		JSONArray jsonArr = json2.getJSONArray("availFareSet");
		System.out.println(jsonArr.toString());
		System.out.println(jsonArr.get(0));
		
		System.out.println("===========================================");
		JSONObject json3 = jsonArr.getJSONObject(0);
		System.out.println(json3.toString());
		System.out.println(json3.get("segFare"));
		System.out.println(json3.get("noOfSeg"));
		
		//�װ��� ����
		System.out.println("================�װ�������================");
		JSONObject json4 = json3.getJSONObject("segFare");
		System.out.println(json4.toString());
		System.out.println(json4.get("carCode"));
		System.out.println(json4.get("carDesc"));
		System.out.println(json4.get("depDate"));
		System.out.println(json4.get("depTime"));
		System.out.println(json4.get("mainFlt"));
		
		//��������
		System.out.println("================��������================");
		JSONObject json5 = json4.getJSONArray("classDetail").getJSONObject(0);
		System.out.println(json5.toString());
		System.out.println(Integer.parseInt(json5.get("fareOrigin").toString()) + 1000);
		
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
