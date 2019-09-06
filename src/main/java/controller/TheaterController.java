package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import crawling.theater.model.Movie;
import crawling.theater.service.CheckCondition;
import crawling.theater.service.MovieListCrawling;
import model.TheaterCondition;
import service.MybatisRepository;

@Controller
@RequestMapping("/theater")
public class TheaterController {
	
	ModelAndView mv = new ModelAndView();
	List<String> movieList = new ArrayList<String>();
	
	
	@Bean
	public List<String> movieListObject() {
		MovieListCrawling movieListCrawling = new MovieListCrawling();
		movieList = movieListCrawling.movieList();
		return movieList;
	}

	@Autowired
	MybatisRepository mr;
	 
	@RequestMapping("/list")
	public ModelAndView theaterList(HttpServletRequest request) throws Exception {
		
		mv.clear();
		String id = (String)request.getSession().getAttribute("id");
		int count =0;
		System.out.println(id);
		if(id != null) {
			count = mr.theater_conditionExistById(id);
		}
		 
		if(count != 0) {
			List conditionList = mr.theater_conditionById(id);
			
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String temp = sdf.format(today);
			today = sdf.parse(temp);
			
			mv.addObject("conditionList", conditionList);
			mv.addObject("today", today);
		} 
		
		mv.addObject("count", count);
		mv.setViewName("theater/list");
		return mv;
	}

	// 조건 등록 =====================================================
	@RequestMapping("/regFirst")
	public ModelAndView regFirst() throws Exception {
		mv.addObject("movieList", movieList);
		System.out.println(movieList);
		List regionList = mr.theaterInfo_region();
		System.out.println(regionList);
		mv.addObject("regionList", regionList);
		
		mv.setViewName("theater/registration");
		return mv;
	}
	
	@RequestMapping(value="/regSecond", produces = "application/text; charset=utf8")
	@ResponseBody
	public String regSecond(HttpServletRequest request) throws Exception {
		System.out.println("regSecond 통과");
		String region_code = request.getParameter("region_code");
		List theaterList = mr.theaterInfo_theater(region_code);
		
		Gson a = new Gson();
		
		System.out.println(theaterList);

		return a.toJson(theaterList);
	}
	
	@RequestMapping(value="/regLast", produces="application/text; charset=utf8")
	@ResponseBody
	public String regLast(HttpServletRequest request) throws Exception {
		String theater_code = request.getParameter("theater_code");
		List roomState = mr.theaterInfo_room(theater_code);
		Gson a = new Gson();
		System.out.println(roomState);
		
		return a.toJson(roomState);
	}
	
	@RequestMapping("/registration")
	public String registration(TheaterCondition condition, @RequestParam("dateValue") String dateValue) throws Exception {
		int num = mr.lastNum();
		String region_name = mr.theaterInfo_region_name(condition.getRegion_code());
		String theater_name = mr.theaterInfo_theater_name(condition.getTheater_code());
		
		SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date target_date = df.parse(dateValue);
		condition.setNum(num+1);
		condition.setRegion_name(region_name);
		condition.setTheater_name(theater_name);
		condition.setTarget_date(target_date);
		System.out.println(condition);
		mr.insertTheaterCondition(condition);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) throws Exception {
		mr.deleteTheaterCondition(num);
		return "redirect:list";
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("num") int num) throws Exception {
		mv.clear();
		TheaterCondition condition = mr.theater_conditionByNum(num);
		CheckCondition checkCondition = new CheckCondition();
		Movie movie = checkCondition.crawlingResult(condition);
		
		int roomsize = 0;
		roomsize = movie.getRoomlist().size();
		
		mv.addObject("roomsize", roomsize);
		mv.addObject("condition", condition);
		mv.addObject("movie", movie);
		System.out.println(movie);
		mv.setViewName("theater/detail");
		return mv;
	}
}
