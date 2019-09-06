package crawling.theater.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieListCrawling {
	
	
	
	public List<String> movieList() {
		
		List<String> movieList = new ArrayList<String>();
		movieList.add("유열의 음악앨범");
		movieList.add("그것- 두 번째 이야기");
		movieList.add("나쁜 녀석들- 더 무비");
		movieList.add("분노의 질주- 홉스&쇼");
		movieList.add("타짜- 원 아이드 잭");
		movieList.add("엑시트");
		
		System.out.println("=======영화 리스트 정보 생성 완료=======");
		return movieList;
	}
	
// 라이브 적용 시 아래 메소드 활성화	
	
//	public List<String> movieList() {
//		String url = "http://www.cgv.co.kr/reserve/show-times/movies.aspx";
//		Document doc = null;
//		
//		try {
//			doc = Jsoup.connect(url).get();
//		} catch(IOException e) {
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		Elements elements = doc.select("div#movie_list").select("li");
//
//		List<String> movieList = new ArrayList<String>();
//		for(int i=0; i<elements.size() ; i++) {
//			movieList.add(elements.get(i).select("strong").text());
//		}
//
//		System.out.println("=======영화 리스트 정보 생성 완료=======");
//		return movieList;
//	}


}
