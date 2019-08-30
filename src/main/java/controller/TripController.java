package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/trip/")
public class TripController {

ModelAndView mv = new ModelAndView();
	
	@RequestMapping("conditionForm")
	public ModelAndView conditionForm() {
		mv.setViewName("Dashio/trip/conditionFormTrip");
		return mv;
	}
	
	@RequestMapping("tripList")
	public ModelAndView tripList() {
		mv.setViewName("Dashio/trip/tripList");
		return mv;
	}
	
}
