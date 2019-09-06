package crawling.theater.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawling.theater.model.Movie;
import crawling.theater.model.Room;
import crawling.theater.model.Time;
import model.TheaterCondition;

public class CheckCondition {
	
	
	public Movie crawlingResult(TheaterCondition condition) {
		
		Movie movie = null;
		
		String url = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?areacode=";
		
		// URL 만들어주기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = sdf.format(condition.getTarget_date());
		url += condition.getRegion_code()+"&theatercode="+condition.getTheater_code()+"&date="+date;
		System.out.println("URL : " +url);
		
		// URL 로 크롤링해오기
		Document doc = crawling(url);
		// 날짜에 해당하는 것인지 확인
		String dateValue = url.split("date=")[1].substring(6, 8);
		if(dateCheck(doc, dateValue)) {
			// 날짜에 해당하는 정보
			List<Element> elList = new ArrayList<Element>();
			elList = makeElementList(doc);
			// 영화명  정보가 등록한 조건과 일치하는지 확인. 특별관 정보가 등록한 조건과 일치하는지 확인. 그리고 결과 도출
			movie = movieCheck(elList, condition.getMovie_name(), condition.getRoom());
			
		}
		return movie;
	}
	
	private Document crawling(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	private List<Element> makeElementList(Document doc){
		Elements elements = doc.select("div.col-times");
		List<Element> elList = new ArrayList<Element>();
		for(int i = 0 ; i<elements.size() ; i++) {
			elList.add(elements.get(i));
		}
		return elList;
	}
	
	
	private boolean dateCheck(Document doc, String dateValue) {
		Elements elements = doc.select("div.day");
		
		for(int i=0; i<elements.size() ; i++) {
			String dateCheck = elements.get(i).select("strong").text();
			String atag = elements.get(i).select("a").attr("title");
			if(dateValue.equals(dateCheck) && atag != null) {
				return true;
			}
		}
		return false;
	}
	
	private Movie movieCheck(List<Element> elList, String movieNameValue, String room) {
		for(int i=0 ; i<elList.size();i++) {
			Element el = elList.get(i);
			String movie_name = el.select("div.info-movie").select("a").text();
//			System.out.println("movie_name : "+ movie_name+", movieNameValue : "+movieNameValue);
			if(movie_name.equals(movieNameValue)) {
				Movie movie = new Movie();
				Elements roomsEl = el.select("div.type-hall");
				List<Room> roomlist = roomCheck(roomsEl, room);
				if(roomlist.size() !=0 ) {
					movie.setRoomlist(roomlist);
					movie.setMovie_name(movie_name);
					movie.setOpeninfo(el.select("div.info-movie").select("em").text());
					return movie;
				}
			}
		}
		return null;
	}
	
	private List<Room> roomCheck(Elements roomsEl, String roomValue){
		List<Room> roomList= new ArrayList<Room>();
		Room room = new Room();
		if(roomValue.equals("2D")) {
			roomValue = "temp";
		}
		for(int i=0 ; i<roomsEl.size();i++) {
			Elements roomEl = roomsEl.get(i).select("div.type-hall");
			String room_name = roomsEl.get(i).select("div.type-hall").select("div.info-hall").select("li").get(1).text();
			if(room_name.equals(roomValue)) {
				room = makeRoom(roomEl);
				roomList.add(room);
				return roomList;
			} else if(room_name.equals("4DX") || room_name.equals("IMAX")) {
				
			} else {
				room = makeRoom(roomEl);
				roomList.add(room);
			}
		}
		return roomList;
	}
	
	
	private Room makeRoom(Elements roomEl) {
		Room room = new Room();
		room.setRoom_type(roomEl.select("div.info-hall").select("li").get(0).text());
		room.setRoom_name(roomEl.select("div.info-hall").select("li").get(1).text());
		room.setRoom_qty(roomEl.select("div.info-hall").select("li").get(2).text());
		Elements timeEl = roomEl.select("div.info-timetable").select("li");
		room.setTimelist(makeTimeList(timeEl));
		return room;
	}
	
	private List<Time> makeTimeList(Elements timeEl){
		List<Time> timeList = new ArrayList<Time>();
		for(int i=0 ; i<timeEl.size();i++) {
			Time time = new Time();
			
			String seatinfo = timeEl.select("span").get(i).text();
			if(seatinfo.equals("매진")) {
				time.setTimeinfo(timeEl.select("em").get(i).text());
				time.setSeatinfo(seatinfo);
			} else {
				time.setTimeinfo(timeEl.select("em").get(i).text());
				time.setReserveurl(timeEl.select("a").get(i).attr("href"));
				
				time.setSeatinfo(timeEl.select("span.txt-lightblue").get(i).text());
			}
			timeList.add(time);
		}
		return timeList;
	}
	

}
