package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/Dashio/")
public class MovieController {
	ModelAndView mv = new ModelAndView();
	@RequestMapping("movie")
	public ModelAndView index() {
		mv.setViewName("Dashio/movie");
		return mv;
	}
}
