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

import model.DepInfo;
import model.Crawling_product;

public class Test3 {
	public static void main(String[] args) throws IOException, JSONException {
		
		String iptUrl = 
				"http://domair.interpark.com/api/booking/airJourney.do?"
				+ "format=json&dep=GMP&arr=CJU&depDate=20190831&"
				+ "adt=1&chd=0&inf=0&tripDivi=0&airlineCode=KE&siteCode=";
		
		//���� ����
		System.out.println("================��������================");
		JSONArray infoArr = readJsonFromUrl(iptUrl)
								.getJSONObject("replyAvailFare")
								.getJSONArray("availFareSet");
		JSONObject info = infoArr
							.getJSONObject(0)
							.getJSONObject("segFare");
		System.out.println("�װ��� �ڵ�: " + info.get("carCode"));
		System.out.println("�װ��� �̸�: " + info.get("carDesc"));
		System.out.println("�װ���: " + info.get("mainFlt"));
		System.out.println("��� ��¥: " + info.get("depDate"));
		System.out.println("��� �ð�: " + info.get("depTime"));
		System.out.println("���� ��¥: " + info.get("arrDate"));
		System.out.println("���� �ð�: " + info.get("arrTime"));
		
		//��������
		System.out.println("=================��������================");
		JSONObject json5 = info.getJSONArray("classDetail").getJSONObject(0);
		System.out.println(Integer.parseInt(json5.get("fareOrigin").toString()) + 1000 + "��");
		
		//�װ��� ����
		System.out.println("================�װ�������================");
		List<JSONObject> tripInfo = new ArrayList<JSONObject>();
		System.out.println(infoArr.length());
		
		for (int i = 0; i < infoArr.length(); i++) {
			tripInfo.add(infoArr.getJSONObject(i).getJSONObject("segFare"));
		}
		
		List<DepInfo> depInfo = new ArrayList<DepInfo>();
		for (int i = 0; i < tripInfo.size(); i++) {
			JSONObject ti = tripInfo.get(i);
			JSONObject classDetail = ti.getJSONArray("classDetail").getJSONObject(0);
			int depFare = Integer.parseInt(classDetail.getString("fareOrigin")) + 1000; 
			DepInfo di = new DepInfo();
			
			di.setDepCarCode(ti.getString("carCode"));
			di.setDepCarDesc(ti.getString("carDesc"));
			di.setDepMainFlt(ti.getString("mainFlt"));
			di.setDepDepCity(ti.getString("depCity"));
			di.setDepDepDesc(ti.getString("depDesc"));
			di.setDepDepDate(ti.getString("depDate"));
			di.setDepDepDay(ti.getString("depDay"));
			di.setDepDepTime(ti.getString("depTime"));
			di.setDepArrCity(ti.getString("arrCity"));
			di.setDepArrDesc(ti.getString("arrDesc"));
			di.setDepArrDate(ti.getString("arrDate"));
			di.setDepArrDay(ti.getString("arrDay"));
			di.setDepArrTime(ti.getString("arrTime"));
			di.setDepNoOfAvailSeat(classDetail.getString("noOfAvailSeat"));
			di.setDepFare(Integer.toString(depFare));
			
			depInfo.add(di);
		}
		
		System.out.println(depInfo);
		
		
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
