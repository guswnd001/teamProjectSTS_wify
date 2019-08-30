package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main/")
public class MainController {

	ModelAndView mv = new ModelAndView();
	
	@RequestMapping("global")
	public ModelAndView global() {
		mv.setViewName("global-master/gindex");
		return mv;
	}
	
	@RequestMapping("Dashio")
	public ModelAndView Dashio() {
		mv.setViewName("Dashio/index");
		return mv;
	}
	
}
